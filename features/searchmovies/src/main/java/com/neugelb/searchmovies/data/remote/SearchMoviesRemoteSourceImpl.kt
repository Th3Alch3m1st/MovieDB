package com.neugelb.searchmovies.data.remote

import com.neugelb.core.di.qualifiers.IoDispatcher
import com.neugelb.core.network.BaseSource
import com.neugelb.core.network.Resource
import com.neugelb.core.model.MoviesResponse
import com.neugelb.core.BuildConfig
import com.neugelb.searchmovies.data.api.SearchMovieApi
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
class SearchMoviesRemoteSourceImpl @Inject constructor(
	private val api: SearchMovieApi,
	@IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SearchMoviesRemoteSource, BaseSource() {

	override suspend fun searchMovies(query: String, pageNumber: Int): Resource<MoviesResponse> {
		val queryMap = mapOf(
			"api_key" to BuildConfig.AUTH_TOKEN,
			"query" to query,
			"page" to pageNumber.toString()
		)

		return safeApiCall(ioDispatcher) {
			api.searchMovies(queryMap)
		}
	}
}