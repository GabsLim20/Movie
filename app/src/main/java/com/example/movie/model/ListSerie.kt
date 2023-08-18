package com.example.movie.model

data class ListSerie(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)