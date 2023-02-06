package com.neugelb.movies.dto.repository

import androidx.paging.PagingData
import com.neugelb.core.model.MovieUIModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rafiqul Hasan
 */
interface LatestMoviesRepository {
	fun getLatestMovies(): Flow<PagingData<MovieUIModel>>
}