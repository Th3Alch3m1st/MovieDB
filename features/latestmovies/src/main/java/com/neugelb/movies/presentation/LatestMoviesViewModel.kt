package com.neugelb.movies.presentation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.neugelb.movies.dto.usecase.LatestMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class LatestMoviesViewModel @Inject constructor(private val useCase: LatestMoviesUseCase) :
	ViewModel() {

	//To avoid duplication call during orientation change
	private val latestMovieState = MutableSharedFlow<Boolean>()
	private val actionLatestMovie = latestMovieState
		.distinctUntilChanged()
		.onStart { emit(true) }

	val latestMovies = actionLatestMovie.flatMapLatest {
		useCase.getLatestMovies()
	}.cachedIn(viewModelScope)

	@VisibleForTesting
	val latestMoviesTest = actionLatestMovie.flatMapLatest {
		useCase.getLatestMovies()
	}

}