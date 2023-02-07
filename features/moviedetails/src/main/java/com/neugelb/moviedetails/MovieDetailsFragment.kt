package com.neugelb.moviedetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.neugelb.core.fragment.BaseFragment
import com.neugelb.feature.moviedetails.R
import com.neugelb.feature.moviedetails.databinding.FragmentMovieDetailsBinding

/**
 * Created by Rafiqul Hasan
 */
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {
	companion object{
		const val ARG_MOVIE = "arg_movie"
	}
	private val arg:MovieDetailsFragmentArgs by navArgs()
	override val layoutResourceId: Int
		get() = R.layout.fragment_movie_details

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		dataBinding.movieInfo = arg.argMovie
		fragmentCommunicator?.setActionBar(dataBinding.toolbar, true)
	}
}