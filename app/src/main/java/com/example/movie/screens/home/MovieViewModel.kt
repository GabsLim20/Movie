package com.example.movie.screens.home

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie.data.DataOrException
import com.example.movie.model.Movie
import com.example.movie.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(application: Application):
    AndroidViewModel(application) {
    val data: MutableState<DataOrException<ArrayList<Movie>,Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception(""))
    )
    private val _viewState = MutableStateFlow(MovieViewState())
    val viewState : StateFlow<MovieViewState> = _viewState.asStateFlow()
    fun getMovies() {
        viewModelScope.launch {
            data.value.loading= true
            //data.value = repository.getMovies()
            MovieRepository().getMovies("2").collect{data ->
                Log.i("Image",data.original_language)
                _viewState.update {
                    it.copy(
                        image = "https://image.tmdb.org/t/p/w500"+data.backdrop_path,
                        title = data.original_title,
                        drama = data.overview
                    )
                }
            }
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }
}
data class MovieViewState(
    val image: String = "",
    val title:String = "",
    val drama:String = ""
)