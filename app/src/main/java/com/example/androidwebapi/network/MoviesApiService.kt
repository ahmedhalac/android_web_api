package com.example.androidwebapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

enum class MovieApiFilter(val value: String) {
    SHOW_UPCOMING("upcoming"),
    SHOW_TOP_RATED("top_rated"),
    SHOW_POPULAR("popular") }

//Logger
private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private var okHttp = OkHttpClient.Builder().addInterceptor(logger)

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(okHttp.build())
    .build()


interface MoviesApiService {
    @GET("{movie_type}")
    suspend fun getProperties(@Path(value = "movie_type", encoded = true) movieId : String,
    @Query("api_key", encoded = true) api_key : String): Movies
}


object PopularMoviesApi {
    val retrofitService : MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java) }
}

