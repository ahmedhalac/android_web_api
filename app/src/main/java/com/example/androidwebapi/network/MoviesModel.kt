package com.example.androidwebapi.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies ( val results : List<Result>) : Parcelable {
    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Result(
        val id: Int,
        val title: String,
        val overview: String,
        @Json(name = "poster_path")
        val posterPath: String,
        @Json(name = "vote_average")
        val voteAverage: String
    ): Parcelable
}

