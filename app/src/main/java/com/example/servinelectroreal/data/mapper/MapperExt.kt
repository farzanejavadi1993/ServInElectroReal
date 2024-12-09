package com.example.servinelectroreal.data.mapper

import com.example.servinelectroreal.data.source.local.GenreLocal
import com.example.servinelectroreal.data.source.remote.GenreEntityRemote
import com.example.servinelectroreal.domain.entity.GenreEntity


fun GenreEntityRemote.mapToGenreLocal() : GenreLocal {
        return GenreLocal(id=id , name =name)
    }

fun GenreLocal.mapToGenreEntity() : GenreEntity {
    return GenreEntity(id=id , name =name)
}