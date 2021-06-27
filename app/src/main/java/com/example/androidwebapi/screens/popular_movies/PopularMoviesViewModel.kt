package com.example.androidwebapi.screens.popular_movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.PopularMoviesApi
import kotlinx.coroutines.launch

class PopularMoviesViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            try {
                val listResult = PopularMoviesApi.retrofitService.getProperties()
                _response.value = "Success: ${listResult} Movies properties retrieved"
            }catch(e : Exception) {
                _response.value = "Failure: ${e.message} "
            }
        }
    }
}