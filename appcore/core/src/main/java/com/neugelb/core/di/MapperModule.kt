package com.neugelb.core.di

import com.neugelb.core.mapper.Mapper
import com.neugelb.core.mapper.MovieInfoToMovieUIModelMapper
import com.neugelb.core.model.MovieInfo
import com.neugelb.core.model.MovieUIModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Rafiqul Hasan
 */
@InstallIn(SingletonComponent::class)
@Module
object MapperModule {
	@Provides
	@Singleton
	fun provideMapper(): Mapper<MovieInfo, MovieUIModel> {
		return MovieInfoToMovieUIModelMapper()
	}
}