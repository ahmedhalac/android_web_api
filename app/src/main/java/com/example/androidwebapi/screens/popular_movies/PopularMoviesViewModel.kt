package com.example.androidwebapi.screens.popular_movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.PopularMovies
import com.example.androidwebapi.network.PopularMoviesApi
import kotlinx.coroutines.launch

enum class MoviesApiStatus {LOADING, ERROR, DONE}

class PopularMoviesViewModel : ViewModel() {
    private val _status = MutableLiveData<MoviesApiStatus>()

    val status: LiveData<MoviesApiStatus>
        get() = _status

    init {
        getPopularMovies()
    }

    private val _properties = MutableLiveData<List<PopularMovies.Result>>()

    val properties: LiveData<List<PopularMovies.Result>>
        get() = _properties

    private fun getPopularMovies() {
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