package com.neugelb.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.neugelb.core.fragment.BaseFragment
import com.neugelb.feature.latestmovies.R
import com.neugelb.feature.latestmovies.databinding.FragmentLatestMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by Rafiqul Hasan
 */

@AndroidEntryPoint
class LatestMoviesFragment : BaseFragment<FragmentLatestMoviesBinding>() {
	private val viewModel:LatestMoviesViewModel by viewModels()

	override val layoutResourceId: Int
		get() = R.layout.fragment_latest_movies


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initToolbar()
		initObserver()

	}



	private fun initToolbar() {
		dataBinding.layoutToolbar.toolbar.title = getString(R.string.title_latest_movies)
		fragmentCommunicator?.setActionBar(dataBinding.layoutToolbar.toolbar, false)
	}

	private fun initObserver() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED){
				viewModel.getLatestMovies().collect{
					Log.e("error","Here it is")
				}
			}
		}
	}
}