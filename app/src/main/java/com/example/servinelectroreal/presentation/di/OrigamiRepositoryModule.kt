package com.example.servinelectroreal.presentation.di

import com.example.servinelectroreal.data.repository.GenreRepositoryImp
import com.example.servinelectroreal.domain.repository.GenreRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrigamiRepositoryModule {
    @Singleton
    @Provides
    fun provideGenreRepository(
        genreRepositoryImp: GenreRepositoryImp
    ): GenreRepositoryInterface = genreRepositoryImp
}