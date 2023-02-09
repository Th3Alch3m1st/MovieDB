package com.neugelb.searchmovies

import com.neugelb.searchmovies.data.api.SearchMovieApiTest
import com.neugelb.searchmovies.data.paging.SearchMoviePagingSourceTest
import com.neugelb.searchmovies.data.remote.SearchMovieRemoteSourceImplTest
import com.neugelb.searchmovies.domain.SearchMovieUseCaseImplTest
import com.neugelb.searchmovies.presentation.SearchMoviesViewModelTest
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
	SearchMovieApiTest::class,
	SearchMovieRemoteSourceImplTest::class,
	SearchMoviePagingSourceTest::class,
	SearchMovieUseCaseImplTest::class,
	SearchMoviesViewModelTest::class
)
class SearchMoviesTestSuite