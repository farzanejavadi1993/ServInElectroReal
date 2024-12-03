package com.example.servinelectroreal.domain.usecase

import com.example.servinelectroreal.data.repository.GenreRepositoryImp
import com.example.servinelectroreal.domain.entity.GenreEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetGenreEntityUseCase @Inject constructor(private val genreRepository: GenreRepositoryImp) {
        suspend fun getGenreEntity(): Flow<List<GenreEntity>> =
            genreRepository.getGenresEntity()
    }
