package com.example.servinelectroreal.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_table")
data class GenreLocal(
    @PrimaryKey
    val id: String ,
    @ColumnInfo("name")
    val name: String ?=null,
)