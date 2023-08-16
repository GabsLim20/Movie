package com.example.movie.network

import com.example.movie.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

interface MovieApi {
    @GET("{movie_id}")
     fun getInformationMovie(
        @Path("movie_id") movieId: String,
        @Query("api_key") apikey: String
    ): Call<Movie>


}