package com.example.androidwebapi.screens.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidwebapi.network.PopularMoviesApi
import com.example.androidwebapi.network.TvShows
import com.example.androidwebapi.network.TvShowsApi
import com.example.androidwebapi.screens.movies_overview.MoviesApiStatus
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsViewModel: ViewModel() {

    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

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
            try {
                val listResult = TvShowsApi.retrofitService.getTvShowProperty()
                _properties.value = listResult.results
            }catch(e : Exception) {
                _response.value = "Failure: ${e.message}"
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