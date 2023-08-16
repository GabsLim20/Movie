package com.example.movie.di

import com.example.movie.network.MovieApi
import com.example.movie.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//@Module
//@InstallIn (SingletonComponent::class)
interface Module : MovieApi {
  //  @Provides
    companion object Factory{
      fun provideMovieApi(): Module{
          return Retrofit.Builder()
              .baseUrl(Constants.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(Module::class.java)

      }
    }

}