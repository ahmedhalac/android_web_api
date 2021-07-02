package com.example.androidwebapi.screens.details

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidwebapi.network.TvShows


class DetailsTvViewModelFactory( private val tvShow: TvShows.Result,
                              private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsTvViewModel::class.java)) {
            return DetailsTvViewModel(tvShow, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}