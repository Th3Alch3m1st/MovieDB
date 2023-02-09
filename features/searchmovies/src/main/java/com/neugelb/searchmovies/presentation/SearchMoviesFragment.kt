package com.neugelb.searchmovies.presentation

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.neugelb.core.fragment.BaseFragment
import com.neugelb.core.loadstateadapter.PagingLoadStateAdapter
import com.neugelb.core.util.DebouncingQueryTextListener
import com.neugelb.core.util.GridItemDecoration
import com.neugelb.core.util.gone
import com.neugelb.core.util.show
import com.neugelb.feature.searchmovies.R
import com.neugelb.feature.searchmovies.databinding.FragmentSearchMoviesBinding
import com.neugelb.moviedetails.MovieDetailsFragment
import com.neugelb.searchmovies.presentation.adapter.SearchMoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by Rafiqul Hasan
 */
@AndroidEntryPoint
class SearchMoviesFragment : BaseFragment<FragmentSearchMoviesBinding>() {
	private val viewModel: SearchMoviesViewModel by viewModels()

	private var itemDecoration: GridItemDecoration? = null
	private var spanCount = 2

	private lateinit var moviesAdapter: SearchMoviesAdapter

	override val layoutResourceId: Int
		get() = R.layout.fragment_search_movies

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		//init recyclerview adapter
		moviesAdapter = SearchMoviesAdapter { movieInfo ->
			val bundle = Bundle().apply {
				putParcelable(MovieDetailsFragment.ARG_MOVIE, movieInfo)
			}
			findNavController().navigate(
				R.id.action_fragment_search_movies_to_movie_details,
				bundle
			)
		}

		spanCount =
			if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
				3
			} else {
				2
			}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setupToolbar()
		initSearchView()
		initAdapterAndRecyclerView()
		initObserver()
	}

	private fun setupToolbar() {
		dataBinding.toolbar.title = getString(R.string.title_search_movies)
		fragmentCommunicator?.setActionBar(dataBinding.toolbar, true)
	}

	private fun initSearchView() {
		with(dataBinding) {
			searchView.setOnQueryTextListener(
				DebouncingQueryTextListener(
					this@SearchMoviesFragment.lifecycle
				) { newText ->
					viewModel.searchMovies(newText)
				}
			)
			searchView.clearFocus()
		}
	}

	private fun initAdapterAndRecyclerView() {
		with(dataBinding) {
			rvSearchResult.apply {
				layoutManager = GridLayoutManager(context, spanCount)
				itemDecoration?.let {
					removeItemDecoration(it)
				}
				itemDecoration = GridItemDecoration(
					requireContext().resources.getDimension(
						com.intuit.sdp.R.dimen._4sdp
					).toInt(),
					spanCount
				)
				addItemDecoration(itemDecoration!!)
			}

			with(moviesAdapter) {
				rvSearchResult.adapter = withLoadStateFooter(
					footer = PagingLoadStateAdapter(moviesAdapter)
				)
				if (itemCount > 0) {
					viewEmpty.root.gone()
				}
			}
		}
	}

	private fun initObserver() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.searchMovies.collect {
					moviesAdapter.submitData(it)
				}
			}
		}

		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				moviesAdapter.loadStateFlow.collect { loadState ->
					//for initial loading dialog
					val isLoading = loadState.refresh is LoadState.Loading
					if (isLoading) {
						fragmentCommunicator?.showLoader()
					} else {
						fragmentCommunicator?.hideLoader()
					}

					//check if first page response is empty
					val isListEmpty =
						loadState.refresh is LoadState.NotLoading && moviesAdapter.itemCount == 0
					if (isListEmpty) {
						dataBinding.viewEmpty.root.show()
						dataBinding.viewEmpty.tvTitle.text = getString(R.string.msg_nothing_found_search)
						dataBinding.viewEmpty.btnTryAgain.gone()
					} else {
						dataBinding.viewEmpty.root.gone()
					}

					// Show the error result if initial load fails.
					val isInitialLoadOrRefreshFail = loadState.source.refresh is LoadState.Error
					if (isInitialLoadOrRefreshFail) {
						val error = (loadState.refresh as LoadState.Error).error
						showHideErrorUI(
							error.message ?: getString(R.string.msg_unknown_error),
							getString(com.neugelb.core.R.string.retry)
						) {
							moviesAdapter.retry()
						}
					}
				}
			}
		}
	}

	private fun showHideErrorUI(title: String, buttonText: String, clickListener: () -> Unit) {
		dataBinding.viewEmpty.root.show()
		dataBinding.viewEmpty.tvTitle.text = title
		dataBinding.viewEmpty.btnTryAgain.text = buttonText
		dataBinding.viewEmpty.btnTryAgain.setOnClickListener {
			clickListener.invoke()
		}
	}
}