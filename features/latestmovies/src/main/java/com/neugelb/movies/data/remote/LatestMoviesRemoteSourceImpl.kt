package com.neugelb.movies.data.remote

import android.util.Log
import com.neugelb.core.di.qualifiers.IoDispatcher
import com.neugelb.core.network.BaseSource
import com.neugelb.core.network.Resource
import com.neugelb.movies.data.api.LatestMoviesApi
import com.neugelb.movies.data.dto.LatestMoviesResponse
import com.neugelb.core.BuildConfig
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Rafiqul Hasan
 */
class LatestMoviesRemoteSourceImpl @Inject constructor(
	private val api: LatestMoviesApi,
	@IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LatestMoviesRemoteSource, BaseSource() {
	override suspend fun getLatestMovies(pageNumber: Int): Resource<LatestMoviesResponse> {
		val queryMap = mapOf(
			"api_key" to BuildConfig.AUTH_TOKEN,
			"page" to pageNumber.toString()
		)
		Log.e("error","LatestMoviesRemoteSourceImpl")
		return safeApiCall(ioDispatcher) {
			Log.e("error","inside LatestMoviesRemoteSourceImpl")
			api.getLatestMovies(queryMap)
		}
	}
}