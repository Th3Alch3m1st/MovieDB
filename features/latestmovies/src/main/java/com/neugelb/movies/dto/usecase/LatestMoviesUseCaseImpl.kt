package com.neugelb.movies.dto.usecase

import android.util.Log
import androidx.paging.PagingData
import com.neugelb.core.model.MovieUIModel
import com.neugelb.movies.dto.repository.LatestMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
class LatestMoviesUseCaseImpl @Inject constructor(
	private val repository: LatestMoviesRepository
) : LatestMoviesUseCase {

	override fun getLatestMovies(): Flow<PagingData<MovieUIModel>> {
		Log.e("error","LatestMoviesUseCaseImpl")
		return repository.getLatestMovies()
	}
}