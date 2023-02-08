package com.neugelb.movies

import com.neugelb.movies.data.api.LatestMoviesApiTest
import com.neugelb.movies.data.paging.LatestMoviesPagingSourceTest
import com.neugelb.movies.data.remote.LatestMovieRemoteSourceImplTest
import com.neugelb.movies.domain.LatestMoviesUseCaseImplTest
import com.neugelb.movies.presentation.LatestMoviesViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

/**
 * Created by Rafiqul Hasan
 */
@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@SuiteClasses(
	LatestMoviesApiTest::class,
	LatestMovieRemoteSourceImplTest::class,
	LatestMoviesPagingSourceTest::class,
	LatestMoviesUseCaseImplTest::class,
	LatestMoviesViewModelTest::class
)
class LatestMoviesTestSuite