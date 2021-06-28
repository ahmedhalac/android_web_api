package com.example.androidwebapi.screens.popular_movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.PopularMovies
import com.example.androidwebapi.network.PopularMoviesApi
import kotlinx.coroutines.launch

class PopularMoviesViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getPopularMovies()
    }

    private val _property = MutableLiveData<PopularMovies.Result>()

    val property: LiveData<PopularMovies.Result>
        get() = _property

    private fun getPopularMovies() {
        viewModelScope.launch {
            try {
                val listResult = PopularMoviesApi.retrofitService.getProperties()
                _response.value = "Success: ${listResult} Movies properties retrieved"
                if (listResult.results.size > 0) {
                    _property.value = listResult.results[0]
                }

            }catch(e : Exception) {
                _response.value = "Failure: ${e.message} "
            }
        }
    }
}