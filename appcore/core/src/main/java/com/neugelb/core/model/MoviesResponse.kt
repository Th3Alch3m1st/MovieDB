package com.neugelb.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(

	@Json(name = "dates")
	val dates: Dates? = null,

	@Json(name = "page")
	val page: Int? = null,

	@Json(name = "total_pages")
	val totalPages: Int? = null,

	@Json(name = "results")
	val results: List<MovieInfo>? = null,

	@Json(name = "total_results")
	val totalResults: Int? = null
)

@JsonClass(generateAdapter = true)
data class Dates(

	@Json(name = "maximum")
	val maximum: String? = null,

	@Json(name = "minimum")
	val minimum: String? = null
)

@JsonClass(generateAdapter = true)
data class MovieInfo(

	@Json(name = "overview")
	val overview: String? = null,

	@Json(name = "original_language")
	val originalLanguage: String? = null,

	@Json(name = "original_title")
	val originalTitle: String? = null,

	@Json(name = "video")
	val video: Boolean? = null,

	@Json(name = "title")
	val title: String? = null,

	@Json(name = "genre_ids")
	val genreIds: List<Int>? = null,

	@Json(name = "poster_path")
	val posterPath: String? = null,

	@Json(name = "backdrop_path")
	val backdropPath: String? = null,

	@Json(name = "release_date")
	val releaseDate: String? = null,

	@Json(name = "popularity")
	val popularity: Double? = null,

	@Json(name = "vote_average")
	val voteAverage: Float? = null,

	@Json(name = "id")
	val id: Int? = null,

	@Json(name = "adult")
	val adult: Boolean? = null,

	@Json(name = "vote_count")
	val voteCount: Int? = null
)
