package com.neugelb.searchmovies

import android.os.Bundle
import android.view.View
import com.neugelb.core.fragment.BaseFragment
import com.neugelb.feature.searchmovies.R
import com.neugelb.feature.searchmovies.databinding.FragmentSearchMoviesBinding

/**
 * Created by Rafiqul Hasan
 */
class FragmentSearchMovies : BaseFragment<FragmentSearchMoviesBinding>() {
	override val layoutResourceId: Int
		get() = R.layout.fragment_search_movies

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setupToolbar()
	}

	private fun setupToolbar() {
		dataBinding.toolbar.title = getString(R.string.title_search_movies)
		fragmentCommunicator?.setActionBar(dataBinding.toolbar, true)
	}
}