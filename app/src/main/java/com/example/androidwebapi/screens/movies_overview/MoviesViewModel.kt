package com.example.androidwebapi.screens.movies_overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.Movies
import com.example.androidwebapi.network.PopularMoviesApi
import kotlinx.coroutines.launch

//enum class for error handling
enum class MoviesApiStatus {LOADING, ERROR, DONE}

class MoviesViewModel : ViewModel() {
    private val _status = MutableLiveData<MoviesApiStatus>()

    val status: LiveData<MoviesApiStatus>
        get() = _status

    init {
        getMovies()
    }

    private val _properties = MutableLiveData<List<Movies.Result>>()

    val properties: LiveData<List<Movies.Result>>
        get() = _properties

    private fun getMovies() {
        viewModelScope.launch {
            _status.value = MoviesApiStatus.LOADING
            try {
                val listResult = PopularMoviesApi.retrofitService.getProperties()
                _properties.value = listResult.results
                _status.value = MoviesApiStatus.DONE
            }catch(e : Exception) {
                _status.value = MoviesApiStatus.ERROR
                //Clears Recycler View
                _properties.value = ArrayList()
            }
        }
    }
}