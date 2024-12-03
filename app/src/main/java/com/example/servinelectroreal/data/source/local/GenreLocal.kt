package com.example.servinelectroreal.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_table")
data class GenreLocal(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String ?=null,
    @ColumnInfo("name")
    val name: String ?=null,
)