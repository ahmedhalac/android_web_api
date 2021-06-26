package com.example.androidwebapi.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PopularMoviesApiService {
    @GET("popular?api_key=b2a4448503d46709ed8c8e90ec1bf7af")
    fun getProperties(): Call<String>
}

object PopularMoviesApi {
    val retrofitService : PopularMoviesApiService by lazy {
        retrofit.create(PopularMoviesApiService::class.java) }
}