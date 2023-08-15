package com.example.movie.network

import com.example.movie.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface MovieApi {
    @GET("{movie_id}")
    suspend fun getInformationMovie(
        @Path("movie_id") movieId: Int
    ): Call<Movie>

    //@GET("pokemon/")
    //    fun requestPokemon(): Call<PokemonListResponse>
    //
    //    @GET("pokemon/{namePokemon}/")
    //    fun requestDetailPokemon(
    //        @Path("namePokemon") namePokemon: String
    //    ): Call<PokemonDetailResponse>
    //
    //    @GET("characteristic/{idPokemon}/")
    //    fun requestDescriptionPokemon(
    //        @Path("idPokemon") idPokemon: String
    //    ): Call<PokemonDescriptionResponse>
}