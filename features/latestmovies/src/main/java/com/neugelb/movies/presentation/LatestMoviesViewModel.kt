package com.neugelb.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.neugelb.core.model.MovieUIModel
import com.neugelb.movies.dto.usecase.LatestMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
@HiltViewModel
class LatestMoviesViewModel @Inject constructor(private val useCase: LatestMoviesUseCase) :
	ViewModel() {


	fun getLatestMovies(): Flow<PagingData<MovieUIModel>> {
		return useCase.getLatestMovies().cachedIn(viewModelScope)
	}
}