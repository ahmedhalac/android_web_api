package com.example.androidwebapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PopularMoviesApiService {
    @GET("popular?api_key=b2a4448503d46709ed8c8e90ec1bf7af")
    suspend fun getProperties(): PopularMovies
}

object PopularMoviesApi {
    val retrofitService : PopularMoviesApiService by lazy {
        retrofit.create(PopularMoviesApiService::class.java) }
}