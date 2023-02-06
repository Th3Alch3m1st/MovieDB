package com.neugelb.movies.mapper

import com.neugelb.core.mapper.Mapper
import com.neugelb.core.model.MovieUIModel
import com.neugelb.movies.data.dto.MovieInfo
import com.neugelb.core.BuildConfig

/**
 * Created by Rafiqul Hasan
 */
class MovieInfoToMovieUIModelMapper() :Mapper<MovieInfo,MovieUIModel>{
	override fun map(input: MovieInfo): MovieUIModel {
		return MovieUIModel(
			id = input.id ?: 0,
			title = input.title ?: "",
			releaseDate = input.releaseDate ?: "",
			overView = input.overview ?: "",
			backDropImage = "${BuildConfig.IMAGE_URL}/original/${input.backdropPath ?: ""}",
			thumbnailBackDropImage = "${BuildConfig.IMAGE_URL}/w500/${input.backdropPath ?: ""}",
			posterImage = "${BuildConfig.IMAGE_URL}/original/${input.posterPath ?: ""}",
			genreIds = input.genreIds ?: listOf(),
			vote = input.voteAverage ?: 0.0f
		)
	}
}