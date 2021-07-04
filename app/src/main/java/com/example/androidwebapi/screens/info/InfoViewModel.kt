package com.example.androidwebapi.screens.info

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.database.MovieDatabaseDao
import com.example.androidwebapi.database.MoviesEntity
import com.example.androidwebapi.formatMovies
import kotlinx.coroutines.launch

class InfoViewModel(val database: MovieDatabaseDao, application: Application)
    : AndroidViewModel(application) {

    private var movie = MutableLiveData<MoviesEntity?>()
    private val movies = database.getAllMovies()

    init {
        initializeMovie()
    }

    private fun initializeMovie() {
        viewModelScope.launch {
            movie.value = getMovieFromDatabase()
        }
    }

    private suspend fun getMovieFromDatabase(): MoviesEntity? {
        return database.getMovie()
    }

    val moviesString = Transformations.map(movies) { movies ->
        formatMovies(movies, application.resources)
    }

    fun onClear() {
        viewModelScope.launch {
            clear()
            movie.value = null
        }
    }

    suspend fun clear() {
        database.clear()
    }


}