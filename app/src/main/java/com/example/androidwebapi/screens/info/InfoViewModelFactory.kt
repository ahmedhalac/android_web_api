package com.example.androidwebapi.screens.info

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.database.MovieDatabaseDao

class InfoViewModelFactory (private val dataSource: MovieDatabaseDao,
            private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoViewModel::class.java)) {
            return InfoViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}