package com.neugelb.movies.data.remote

import com.neugelb.core.network.Resource
import com.neugelb.movies.data.dto.LatestMoviesResponse
import retrofit2.Response

/**
 * Created by Rafiqul Hasan
 */
interface LatestMoviesRemoteSource {
	suspend fun getLatestMovies(pageNumber:Int): Resource<LatestMoviesResponse>
}