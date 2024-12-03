package com.example.servinelectroreal.data.source.remote

import androidx.room.ColumnInfo
import com.example.servinelectroreal.data.source.local.GenreLocal
import com.google.gson.annotations.SerializedName


data class GenresRemote(
    @SerializedName("genres")
    var genres: List<GenreEntityRemote> = arrayListOf()
)

data class GenreEntityRemote(
    @SerializedName("id")
    val id: String ?=null,
    @SerializedName("name")
    val name: String ?=null,
)
