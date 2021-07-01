package com.example.androidwebapi.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDatabaseDao {

    @Insert
    suspend fun insert(movie: MoviesEntity)

    @Update
    suspend fun update(movie: MoviesEntity)

    @Query("SELECT * FROM movies_table WHERE id = :key")
    suspend fun get(key: Long): MoviesEntity

    @Query("DELETE FROM movies_table")
    suspend fun clear()

    @Query("SELECT * FROM movies_table ORDER BY id DESC LIMIT 1")
    suspend fun getMovie() : MoviesEntity?

    @Query("SELECT * FROM movies_table ORDER BY id DESC")
    fun getAllMovies(): LiveData<List<MoviesEntity>>

}