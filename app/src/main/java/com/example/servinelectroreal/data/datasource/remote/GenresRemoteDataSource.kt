package com.example.servinelectroreal.data.datasource.remote

import com.example.servinelectroreal.data.source.remote.GenresRemote
import kotlinx.coroutines.flow.Flow

interface GenresRemoteDataSource {
    suspend fun genresList(apiKey: String): GenresRemote

}