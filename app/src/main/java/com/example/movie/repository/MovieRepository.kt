package com.example.movie.repository

import android.util.Log
import com.example.movie.di.Module
import com.example.movie.model.Movie
import com.example.movie.util.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MovieRepository {
    suspend fun getMovies(id: String) = callbackFlow<Movie> {
        withContext(Dispatchers.IO) {
            Log.i("entry","holi")
            val httpResponse = Module.provideMovieApi().getInformationMovie(id,API_KEY)
            httpResponse.enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    Log.i("Log","ff")
                    when(response.code()) {
                        200 -> {
                            val dataResponse = response.body()!!
                            Log.i("data que recibimos ->", dataResponse.toString())
                            trySend(dataResponse)
                        }
                        else -> {
                            Log.e("error con codigo -> ", response.code().toString())
                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.e("error peor -> ", t.message!!, t.cause)
                }

            })
        }

        awaitClose {  }
    }
}