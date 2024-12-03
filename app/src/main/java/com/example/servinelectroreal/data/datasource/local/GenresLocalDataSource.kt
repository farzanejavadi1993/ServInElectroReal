package com.example.servinelectroreal.data.datasource.local

import com.example.servinelectroreal.data.source.local.GenreLocal
import kotlinx.coroutines.flow.Flow

interface GenresLocalDataSource {
    fun getGenresLocal(): Flow<List<GenreLocal>>

    suspend fun insertGenreLocal(genresLocal: GenreLocal)

    fun sizeGenresLocal(): Int
}