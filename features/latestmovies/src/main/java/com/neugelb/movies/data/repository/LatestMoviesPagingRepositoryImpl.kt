package com.neugelb.movies.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.neugelb.core.mapper.Mapper
import com.neugelb.core.model.MovieUIModel
import com.neugelb.movies.data.dto.MovieInfo
import com.neugelb.movies.data.paging.LatestMoviesPagingSource
import com.neugelb.movies.data.remote.LatestMoviesRemoteSource
import com.neugelb.movies.dto.repository.LatestMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
class LatestMoviesPagingRepositoryImpl @Inject constructor(
	private val remote: LatestMoviesRemoteSource,
	private val mapper: Mapper<MovieInfo, MovieUIModel>
) : LatestMoviesRepository {
	companion object {
		//no custom paging size movie db
		const val PAGING_SIZE = 20
	}

	override fun getLatestMovies(): Flow<PagingData<MovieUIModel>> {
		Log.e("error","LatestMoviesPagingRepositoryImpl")
		return Pager(
			config = PagingConfig(
				pageSize = PAGING_SIZE,
				prefetchDistance = PAGING_SIZE,
				initialLoadSize = PAGING_SIZE
			),
			initialKey = 1,
			pagingSourceFactory = { LatestMoviesPagingSource(remote, mapper) }
		).flow
	}
}