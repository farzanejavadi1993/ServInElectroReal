package com.example.servinelectroreal.data.mapper

import com.example.servinelectroreal.data.source.local.GenreLocal
import com.example.servinelectroreal.domain.entity.GenreEntity
import javax.inject.Inject

class ModelMapper @Inject constructor() : ToEntityMapper {
    override fun mapFromEntity(genreLocal: GenreLocal): GenreEntity {
        val genreEntity = GenreEntity()
        genreEntity.id = genreLocal.id
        genreEntity.name = genreLocal.name
        return genreEntity
    }

    fun mapFromEntities(entities: List<GenreLocal>): List<GenreEntity> {
        return entities.map { mapFromEntity(it) }
    }
}