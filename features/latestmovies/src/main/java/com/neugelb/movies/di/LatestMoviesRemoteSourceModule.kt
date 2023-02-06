package com.neugelb.movies.di

import com.neugelb.movies.data.remote.LatestMoviesRemoteSource
import com.neugelb.movies.data.remote.LatestMoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created By Rafiqul Hasan
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LatestMoviesRemoteSourceModule {
	@Binds
	@Singleton
	abstract fun provideLatestMovieRemoteSource(sourceImpl: LatestMoviesRemoteSourceImpl): LatestMoviesRemoteSource
}