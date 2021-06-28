package com.example.androidwebapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

enum class MoviesApiFilter(val value: String) {
    SHOW_TOP_RATED("top_rated"),
    SHOW_UPCOMING("upcoming")}

private const val API_KEY = "?api_key=b2a4448503d46709ed8c8e90ec1bf7af"
private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface MoviesApiService {
    @GET("popular$API_KEY")
    suspend fun getProperties(): Movies
}

object PopularMoviesApi {
    val retrofitService : MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java) }
}