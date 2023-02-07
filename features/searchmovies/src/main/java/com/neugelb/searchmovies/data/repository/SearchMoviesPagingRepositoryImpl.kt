package com.neugelb.searchmovies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.neugelb.core.mapper.Mapper
import com.neugelb.core.model.MovieUIModel
import com.neugelb.core.model.MovieInfo
import com.neugelb.searchmovies.data.paging.SearchMoviesPagingSource
import com.neugelb.searchmovies.data.remote.SearchMoviesRemoteSource
import com.neugelb.searchmovies.dto.repository.SearchMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
class SearchMoviesPagingRepositoryImpl @Inject constructor(
	private val remote: SearchMoviesRemoteSource,
	private val mapper: Mapper<MovieInfo, MovieUIModel>
) : SearchMoviesRepository {
	companion object {
		//no custom paging size movie db
		const val PAGING_SIZE = 20
	}

	override suspend fun searchMovies(query: String): Flow<PagingData<MovieUIModel>> {
		return Pager(
			config = PagingConfig(
				pageSize = PAGING_SIZE,
				prefetchDistance = PAGING_SIZE,
				initialLoadSize = PAGING_SIZE
			),
			initialKey = 1,
			pagingSourceFactory = { SearchMoviesPagingSource(query, remote, mapper) }
		).flow
	}
}