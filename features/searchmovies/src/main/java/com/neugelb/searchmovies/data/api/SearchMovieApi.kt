package com.neugelb.searchmovies.data.api

import com.neugelb.core.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Rafiqul Hasan
 */
interface SearchMovieApi {
	@GET("search/movie")
	suspend fun searchMovies(@QueryMap queryMap: Map<String, String>): Response<MoviesResponse>
}