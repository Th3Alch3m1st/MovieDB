package com.neugelb.movies.di


import com.neugelb.core.mapper.Mapper
import com.neugelb.core.model.MovieUIModel
import com.neugelb.movies.data.api.LatestMoviesApi
import com.neugelb.movies.data.dto.MovieInfo
import com.neugelb.movies.mapper.MovieInfoToMovieUIModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created By Rafiqul Hasan
 */
@Module
@InstallIn(SingletonComponent::class)
object  LatestMoviesAPIModule {
	@Provides
	@Singleton
	fun provideImageSearchApi(retrofit: Retrofit): LatestMoviesApi {
		return retrofit.create(LatestMoviesApi::class.java)
	}
	@Provides
	@Singleton
	fun provideMapper(): Mapper<MovieInfo, MovieUIModel> {
		return MovieInfoToMovieUIModelMapper()
	}
}