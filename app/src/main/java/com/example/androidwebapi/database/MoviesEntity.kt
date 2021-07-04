package com.example.androidwebapi.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class MoviesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "title")
    var title: String? = "",
    @ColumnInfo(name = "vote")
    var vote: String? = ""
)