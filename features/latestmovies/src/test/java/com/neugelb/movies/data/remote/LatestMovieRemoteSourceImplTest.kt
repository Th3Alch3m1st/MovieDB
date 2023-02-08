package com.neugelb.movies.data.remote

import com.neugelb.core.network.Resource
import com.neugelb.movies.data.TestUtils
import com.neugelb.movies.data.TestUtils.getOkHttpClient
import com.neugelb.movies.data.api.LatestMoviesApi
import com.neugelb.movies.data.api.LatestMoviesApiTest
import com.neugelb.testutil.shouldEqual
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Rafiqul Hasan
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class LatestMovieRemoteSourceImplTest {
	@get:Rule
	val mockWebServer = MockWebServer()

	private lateinit var api: LatestMoviesApi
	private lateinit var sutImageSearchRemoteSourceImpl: LatestMoviesRemoteSourceImpl

	@Before
	fun setUp() {
		val moshi = Moshi.Builder()
			.build()

		api = Retrofit.Builder()
			.baseUrl(mockWebServer.url("/"))
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.client(getOkHttpClient())
			.build()
			.create(LatestMoviesApi::class.java)

		sutImageSearchRemoteSourceImpl = LatestMoviesRemoteSourceImpl(api, UnconfinedTestDispatcher())
	}

	@After
	fun shutDown() {
		mockWebServer.shutdown()
	}

	@Test
	fun `getLatestMovies for first call should return first paging Data`() {
		runBlocking {
			//Arrange
			mockWebServer.enqueue(TestUtils.mockResponse(LatestMoviesApiTest.PAGE_1_DATA))

			// Act
			val response = sutImageSearchRemoteSourceImpl.getLatestMovies(LatestMoviesApiTest.PAGE_NO_1)

			// Assert
			(response as Resource.Success).data.totalResults shouldEqual LatestMoviesApiTest.TOTAL_ITEM
			response.data.results?.size shouldEqual LatestMoviesApiTest.PAGE_LIMIT
			response.data.results?.get(0)?.id shouldEqual LatestMoviesApiTest.PAGE_1_0_INDEX_ID
		}
	}

	@Test
	fun `getLatestMovies for second call should return second paging Data`() {
		runBlocking {
			//Arrange
			mockWebServer.enqueue(TestUtils.mockResponse(LatestMoviesApiTest.PAGE_2_DATA))

			// Act
			val response = sutImageSearchRemoteSourceImpl.getLatestMovies(LatestMoviesApiTest.PAGE_NO_2)

			// Assert
			(response as Resource.Success).data.totalResults shouldEqual LatestMoviesApiTest.TOTAL_ITEM
			response.data.results?.size shouldEqual LatestMoviesApiTest.PAGE_LIMIT
			response.data.results?.get(0)?.id shouldEqual LatestMoviesApiTest.PAGE_2_0_INDEX_ID
		}
	}

	@Test
	fun `getLatestMovies for end call should return end paging Data`() {
		runBlocking {
			//Arrange
			mockWebServer.enqueue(TestUtils.mockResponse(LatestMoviesApiTest.PAGE_END_DATA))

			// Act
			val response = sutImageSearchRemoteSourceImpl.getLatestMovies(LatestMoviesApiTest.PAGE_END)

			// Assert
			(response as Resource.Success).data.totalResults shouldEqual LatestMoviesApiTest.TOTAL_ITEM
			response.data.results?.size shouldEqual LatestMoviesApiTest.PAGE_END_SIZE
			response.data.results?.get(0)?.id shouldEqual LatestMoviesApiTest.PAGE_END_0_INDEX_ID
		}
	}
}