package com.example.servinelectroreal.data.repository

import android.util.Log
import com.example.servinelectroreal.data.datasource.local.GenresLocalDataSource
import com.example.servinelectroreal.data.datasource.remote.GenresRemoteDataSource
import com.example.servinelectroreal.data.mapper.mapToGenreEntity
import com.example.servinelectroreal.data.mapper.mapToGenreLocal
import com.example.servinelectroreal.domain.entity.GenreEntity
import com.example.servinelectroreal.domain.repository.GenreRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GenreRepositoryImp @Inject constructor(
    private val genresLocalDataSource: GenresLocalDataSource,
    private val genresRemoteDataSource: GenresRemoteDataSource
) : GenreRepositoryInterface {


    override suspend fun getGenresEntity(): Flow<List<GenreEntity>> = flow {

        genresLocalDataSource.getGenresLocal().map { genresLocal ->
            val genreEntity = genresLocal.map { it.mapToGenreEntity() }
            emit(genreEntity)
        }


        try {
            val response = genresRemoteDataSource.genresList("59cd6896d8432f9c69aed9b86b9c2931")
            val genreLocal = response.genres.map { it.mapToGenreLocal() }
            genresLocalDataSource.insertGenreLocal(genreLocal)


        } catch (e: Exception) {
            println("XXXX : Error=${e.message}")
        }


    }


}