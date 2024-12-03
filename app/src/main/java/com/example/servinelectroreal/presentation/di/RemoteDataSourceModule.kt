package com.example.servinelectroreal.presentation.di

import com.example.servinelectroreal.data.datasource.remote.GenresRemoteDataSource
import com.example.servinelectroreal.data.datasource.remote.GenresRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Singleton
    @Provides
    fun provideGenreRemoteDataSource(
        genresRemoteDataSourceImp: GenresRemoteDataSourceImp
    ): GenresRemoteDataSource = genresRemoteDataSourceImp
}