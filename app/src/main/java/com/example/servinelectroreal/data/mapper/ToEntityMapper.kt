package com.example.servinelectroreal.data.mapper

import com.example.servinelectroreal.data.source.local.GenreLocal
import com.example.servinelectroreal.domain.entity.GenreEntity

interface ToEntityMapper {
    fun mapFromEntity(genreLocal: GenreLocal): GenreEntity
}