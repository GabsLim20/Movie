package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    @SerializedName("title")
    val original_title: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    @SerializedName("details")
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
fun getMovies(): List<Movie> {
    return emptyList()
}