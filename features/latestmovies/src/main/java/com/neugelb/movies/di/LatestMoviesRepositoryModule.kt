package com.neugelb.movies.di

import com.neugelb.movies.data.repository.LatestMoviesPagingRepositoryImpl
import com.neugelb.movies.dto.repository.LatestMoviesRepository
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
abstract class LatestMoviesRepositoryModule {

	@Binds
	@Singleton
	abstract fun provideLatestMoviesRepository(useCaseImpl: LatestMoviesPagingRepositoryImpl): LatestMoviesRepository
}