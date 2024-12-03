package com.example.servinelectroreal.presentation.di

import com.example.servinelectroreal.data.source.remote.GenreRemoteInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideApiService(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/3/")
        .build()

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit): GenreRemoteInterface {
        return retrofit.create(GenreRemoteInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideApiHelper(remoteServiceImpl: RemoteServiceImpl): RemoteService = remoteServiceImpl
}