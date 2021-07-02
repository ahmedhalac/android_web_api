package com.example.androidwebapi.screens.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidwebapi.network.TvShows

class DetailsTvViewModel(tvShow: TvShows.Result, app: Application) : AndroidViewModel(app) {
    private val _selectedTvShow = MutableLiveData<TvShows.Result>()
    val selectedTvShow: LiveData<TvShows.Result>
        get() = _selectedTvShow

    init {
        _selectedTvShow.value = tvShow
    }
}