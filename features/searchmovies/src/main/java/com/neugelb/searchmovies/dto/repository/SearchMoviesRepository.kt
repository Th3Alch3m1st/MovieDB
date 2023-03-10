package com.neugelb.searchmovies.dto.repository

import androidx.paging.PagingData
import com.neugelb.core.model.MovieUIModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rafiqul Hasan
 */
interface SearchMoviesRepository {
	suspend fun searchMovies(query: String): Flow<PagingData<MovieUIModel>>
}