package com.example.androidwebapi.screens.movies_overview

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.MovieApiFilter
import com.example.androidwebapi.network.Movies
import com.example.androidwebapi.network.PopularMoviesApi
import kotlinx.coroutines.launch

//enum class for error handling
enum class MoviesApiStatus {LOADING, ERROR, DONE}
private const val API_KEY = "b2a4448503d46709ed8c8e90ec1bf7af"

class MoviesViewModel : ViewModel() {
    private val _status = MutableLiveData<MoviesApiStatus>()

    val status: LiveData<MoviesApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<Movies.Result>>()

    val properties: LiveData<List<Movies.Result>>
        get() = _properties

    private val _navigateToSelectedMovie = MutableLiveData<Movies.Result>()
    val navigateToSelectedMovie: LiveData<Movies.Result>
        get() = _navigateToSelectedMovie

    init {
        getMovies(MovieApiFilter.SHOW_POPULAR)
    }

    private fun getMovies(filter: MovieApiFilter) {
        viewModelScope.launch {
            _status.value = MoviesApiStatus.LOADING
            try {
                val listResult = PopularMoviesApi.retrofitService.getProperties(filter.value, API_KEY)
                _properties.value = listResult.results
                _status.value = MoviesApiStatus.DONE
            }catch(e : Exception) {
                _status.value = MoviesApiStatus.ERROR
                //Clears Recycler View
                _properties.value = ArrayList()
            }
        }
    }

    fun displayMovieDetails(movie: Movies.Result) {
        _navigateToSelectedMovie.value = movie
    }

    fun displayMovieDetailsComplete() {
        _navigateToSelectedMovie.value = null
    }

    fun updateFilter(filter: MovieApiFilter) {
        getMovies(filter)
    }

}