package com.example.servinelectroreal.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface GenreRemoteInterface {
    @GET("genre/movie/list")
    suspend fun genresList(@Query("api_key") apiKey: String): GenresRemote

}