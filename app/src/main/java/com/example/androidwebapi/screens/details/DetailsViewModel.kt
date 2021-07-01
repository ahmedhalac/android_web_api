package com.example.androidwebapi.screens.details

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.lifecycle.*
import com.example.androidwebapi.database.MovieDatabaseDao
import com.example.androidwebapi.database.MoviesEntity
import com.example.androidwebapi.formatMovies
import com.example.androidwebapi.network.Movies
import kotlinx.coroutines.launch

class DetailsViewModel(val database: MovieDatabaseDao,
    movie: Movies.Result, application: Application) : AndroidViewModel(application) {

    private var movie = MutableLiveData<MoviesEntity?>()

    private val _selectedMovie = MutableLiveData<Movies.Result>()
    val selectedMovie: LiveData<Movies.Result>
        get() = _selectedMovie

    init {
        _selectedMovie.value = movie
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

    fun onSaveMovie() {
        viewModelScope.launch {
            val newMovie = MoviesEntity()
            newMovie.title = _selectedMovie.value?.title
            newMovie.vote = _selectedMovie.value?.voteAverage
            insert(newMovie)
        }
    }


    private suspend fun insert(_movie: MoviesEntity) {
        database.insert(_movie)
    }

}