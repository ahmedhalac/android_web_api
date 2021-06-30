package com.example.androidwebapi.screens.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidwebapi.network.Movies

class DetailsViewModel( movie: Movies.Result, app: Application) : AndroidViewModel(app) {
    private val _selectedMovie = MutableLiveData<Movies.Result>()
    val selectedMovie: LiveData<Movies.Result>
        get() = _selectedMovie

    init {
        _selectedMovie.value = movie
    }
}