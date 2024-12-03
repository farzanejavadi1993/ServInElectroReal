package com.example.servinelectroreal.domain.repository

import com.example.servinelectroreal.domain.entity.GenreEntity
import kotlinx.coroutines.flow.Flow

interface GenreRepositoryInterface {
   suspend fun getGenresEntity () : Flow<List<GenreEntity>>
}