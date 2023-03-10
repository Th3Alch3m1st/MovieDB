package com.neugelb.movies.dto.usecase

import androidx.paging.PagingData
import com.neugelb.core.model.MovieUIModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rafiqul Hasan
 */
interface SearchMoviesUseCase {
	suspend fun searchMovies(query: String): Flow<PagingData<MovieUIModel>>
}