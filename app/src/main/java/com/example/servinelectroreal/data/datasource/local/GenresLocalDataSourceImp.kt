package com.example.servinelectroreal.data.datasource.local

import com.example.servinelectroreal.data.source.local.GenreLocal
import com.example.servinelectroreal.data.source.local.GenreDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GenresLocalDataSourceImp @Inject constructor(
    private val genresDao: GenreDao
) : GenresLocalDataSource {


    override fun getGenresLocal(): Flow<List<GenreLocal>> = genresDao.getGenresLocal()

    override suspend fun insertGenreLocal(genresLocal: GenreLocal) =
        genresDao.insertGenreLocal(genresLocal)

    override fun sizeGenresLocal(): Int = genresDao.sizeGenresLocal()


}