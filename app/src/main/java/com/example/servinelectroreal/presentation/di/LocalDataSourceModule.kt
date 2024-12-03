package com.example.servinelectroreal.presentation.di

import com.example.servinelectroreal.data.datasource.local.GenresLocalDataSource
import com.example.servinelectroreal.data.datasource.local.GenresLocalDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideGenreLocalDataSource(
        genresLocalDataSourceImp: GenresLocalDataSourceImp
    ): GenresLocalDataSource = genresLocalDataSourceImp
}