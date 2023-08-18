package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    @SerializedName("title")
    val original_title: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    val release_date: String,
    @SerializedName("details")
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)