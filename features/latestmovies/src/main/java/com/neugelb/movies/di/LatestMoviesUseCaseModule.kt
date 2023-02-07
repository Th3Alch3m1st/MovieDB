package com.neugelb.movies.di

import com.neugelb.movies.dto.usecase.LatestMoviesUseCase
import com.neugelb.movies.dto.usecase.LatestMoviesUseCaseImpl
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
abstract class LatestMoviesUseCaseModule {

	@Binds
	@Singleton
	abstract fun provideLatestMoviesUseCase(useCaseImpl: LatestMoviesUseCaseImpl): LatestMoviesUseCase
}