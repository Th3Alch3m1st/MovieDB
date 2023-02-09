package com.neugelb.searchmovies.di

import com.neugelb.searchmovies.data.remote.SearchMoviesRemoteSource
import com.neugelb.searchmovies.fakeremotesource.FakeMovieSearchRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

/**
 * Created By Rafiqul Hasan
 */
@Module
@TestInstallIn(
	components = [SingletonComponent::class],
	replaces = [SearchMoviesRemoteSourceModule::class]
)
abstract class FakeSearchMoviesRemoteSourceModule {
	@Singleton
	@Binds
	abstract fun provideFakeMovieSearchRemoteSource(impl: FakeMovieSearchRemoteSourceImpl): SearchMoviesRemoteSource
}