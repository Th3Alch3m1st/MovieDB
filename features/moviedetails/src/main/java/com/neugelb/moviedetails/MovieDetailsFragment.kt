package com.neugelb.moviedetails

import android.os.Bundle
import android.view.View
import com.neugelb.core.fragment.BaseFragment
import com.neugelb.feature.moviedetails.R
import com.neugelb.feature.moviedetails.databinding.FragmentMovieDetailsBinding

/**
 * Created by Rafiqul Hasan
 */
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {
	override val layoutResourceId: Int
		get() = R.layout.fragment_movie_details

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		fragmentCommunicator?.setActionBar(dataBinding.toolbar, true)
	}
}