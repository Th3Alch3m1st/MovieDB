package com.neugelb.searchmovies.dto.usecase

import androidx.paging.PagingData
import com.neugelb.core.model.MovieUIModel
import com.neugelb.movies.dto.usecase.SearchMoviesUseCase
import com.neugelb.searchmovies.dto.repository.SearchMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
class SearchMoviesUseCaseImpl @Inject constructor(
	private val repository: SearchMoviesRepository
) : SearchMoviesUseCase {

	override suspend fun searchMovies(query: String): Flow<PagingData<MovieUIModel>> {
		return repository.searchMovies(query)
	}
}