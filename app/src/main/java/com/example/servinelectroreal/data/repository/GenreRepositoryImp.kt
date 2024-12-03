package com.example.servinelectroreal.data.repository

import com.example.servinelectroreal.data.datasource.local.GenresLocalDataSource
import com.example.servinelectroreal.data.datasource.remote.GenresRemoteDataSource
import com.example.servinelectroreal.data.mapper.ModelMapper
import com.example.servinelectroreal.domain.entity.GenreEntity
import com.example.servinelectroreal.domain.repository.GenreRepositoryInterface
import com.example.servinelectroreal.presentation.ui.MVIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GenreRepositoryImp @Inject constructor(
    private val genresLocalDataSource: GenresLocalDataSource,
    private val genresRemoteDataSource: GenresRemoteDataSource,
    private val modelMapper: ModelMapper
) : GenreRepositoryInterface {


    override suspend fun getGenresEntity(): Flow<List<GenreEntity>> = flow {
        if (genresLocalDataSource.sizeGenresLocal() == 0) {
            emit(MVIState.Loading)
        } else {
            genresLocalDataSource.getGenresLocal().collect {
                emit(MVIState.Success(modelMapper.mapFromEntities(it)))
            }
        }
        try {
            val response = genresRemoteDataSource.genresList("59cd6896d8432f9c69aed9b86b9c2931\n")
            genresLocalDataSource.insertGenreLocal(response?.collect{it.genres}!!)
            genresLocalDataSource.getGenresLocal().collect {
                emit(MVIState.Success(modelMapper.mapFromEntities(it)))
            }
        } catch (e: Exception) {
            emit(MVIState.Error(e))
        }
    }



}