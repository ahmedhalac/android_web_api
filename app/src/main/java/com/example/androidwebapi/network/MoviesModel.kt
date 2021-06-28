package com.example.androidwebapi.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Movies (
    val results : List<Result>
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        val id: Int,
        val title: String,
        @Json(name = "poster_path")
        val posterPath: String,
        @Json(name = "vote_average")
        val voteAverage: Double
    )
}

