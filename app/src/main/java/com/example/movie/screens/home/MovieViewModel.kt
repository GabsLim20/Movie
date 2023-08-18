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
class MovieViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    val data: MutableState<DataOrException<ArrayList<Movie>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception(""))
    )
    private val _viewState = MutableStateFlow(MovieViewState())
    private val _viewStateList = MutableStateFlow(MovieListViewState())
    val viewStateListMovie: StateFlow<MovieListViewState> = _viewStateList.asStateFlow()
    /*fun getMovies() {
        viewModelScope.launch {
            data.value.loading = true
            MovieRepository().getMovies("2").collect { data ->
                _viewState.update {
                    it.copy(
                        image = "https://image.tmdb.org/t/p/w500" + data.backdrop_path,
                        title = data.original_title,
                        drama = data.overview
                    )
                }
            }
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }*/

    fun getList() {
        viewModelScope.launch {
            data.value.loading = true
            MovieRepository().getList().collect { data ->
                Log.i("Image", data.results.toString())
                _viewStateList.update { information ->
                    information.copy(
                        movieList = data.results.map {
                            MovieInformation(
                                image = "https://image.tmdb.org/t/p/w500" + it.backdrop_path,
                                title = it.original_title,
                                drama = it.overview
                            )
                        }
                    )
                }
            }
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }

    fun getListSerie() {
        viewModelScope.launch {
            data.value.loading = true
            MovieRepository().getListSerie().collect { data ->
                Log.i("Image", data.results.toString())
                _viewStateList.update { information ->
                    information.copy(
                        serieList = data.results.map {
                            MovieInformation(
                                image = "https://image.tmdb.org/t/p/w500" + it.backdrop_path,
                                title = it.name,
                                drama = it.overview
                            )
                        }
                    )
                }
            }
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }
    fun refreshHeader(image: String = "", title: String = "", drama: String = ""){
        _viewStateList.update {
            it.copy(
                image = "https://image.tmdb.org/t/p/w500" + image,
                title = title,
                drama = drama
            )
        }
    }
}

data class MovieViewState(
    val image: String = "",
    val title: String = "",
    val drama: String = ""
)

data class MovieInformation(
    val image: String = "",
    val title: String = "",
    val drama: String = ""
)

data class MovieListViewState(
    val movieList: List<MovieInformation> = emptyList(),
    val serieList: List<MovieInformation> = emptyList(),
    val image: String = "",
    val title: String = "",
    val drama: String = ""
)