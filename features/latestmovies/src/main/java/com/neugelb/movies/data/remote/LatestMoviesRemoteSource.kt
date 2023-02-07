package com.neugelb.movies.data.remote

import com.neugelb.core.network.Resource
import com.neugelb.core.model.MoviesResponse

/**
 * Created by Rafiqul Hasan
 */
interface LatestMoviesRemoteSource {
	suspend fun getLatestMovies(pageNumber:Int): Resource<MoviesResponse>
}