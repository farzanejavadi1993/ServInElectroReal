package com.example.servinelectroreal.data.datasource.remote

import com.example.servinelectroreal.data.source.remote.GenresRemote
import com.example.servinelectroreal.data.source.remote.GenreRemoteInterface
import javax.inject.Inject

class GenresRemoteDataSourceImp @Inject constructor(
    private val remoteService: GenreRemoteInterface
) : GenresRemoteDataSource {

    override suspend fun genresList(apiKey: String):GenresRemote =
        remoteService.genresList(apiKey)

}