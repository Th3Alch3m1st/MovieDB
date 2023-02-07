package com.neugelb.searchmovies.data.remote

import com.neugelb.core.model.MoviesResponse
import com.neugelb.core.network.Resource

/**
 * Created by Rafiqul Hasan
 */
interface SearchMoviesRemoteSource {
	suspend fun searchMovies(query: String, pageNumber: Int): Resource<MoviesResponse>
}