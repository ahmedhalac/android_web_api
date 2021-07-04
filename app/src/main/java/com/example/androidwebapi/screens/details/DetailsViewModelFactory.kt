package com.example.androidwebapi.screens.details

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.database.MovieDatabaseDao
import com.example.androidwebapi.network.Movies

class DetailsViewModelFactory(private val dataSource: MovieDatabaseDao,
   private val movie: Movies.Result,
   private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(dataSource, movie, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}