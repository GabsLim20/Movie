package com.example.movie.repository

import com.example.movie.network.MovieApi
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieApi
) {

}