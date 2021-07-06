package com.example.androidwebapi.screens.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.TvShows
import com.example.androidwebapi.network.TvShowsApi
import kotlinx.coroutines.launch


enum class TvShowsApiStatus {LOADING, ERROR, DONE}

class TvShowsViewModel: ViewModel() {

    private val _status = MutableLiveData<TvShowsApiStatus>()

    val status: LiveData<TvShowsApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<TvShows.Result>>()

    val properties: LiveData<List<TvShows.Result>>
        get() = _properties

    private val _navigateToSelectedTvShow = MutableLiveData<TvShows.Result>()
    val navigateToSelectedTvShow: LiveData<TvShows.Result>
        get() = _navigateToSelectedTvShow

    init {
        getTvShows()
    }

    private fun getTvShows() {
        viewModelScope.launch {
            _status.value = TvShowsApiStatus.LOADING
            try {
                val listResult = TvShowsApi.retrofitService.getTvShowProperty()
                _properties.value = listResult.results
                _status.value = TvShowsApiStatus.DONE
            }catch(e : Exception) {
                _status.value = TvShowsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayTvShowDetails(tvShow: TvShows.Result) {
        _navigateToSelectedTvShow.value = tvShow
    }

    fun displayTvShowDetailsComplete() {
        _navigateToSelectedTvShow.value = null
    }
}