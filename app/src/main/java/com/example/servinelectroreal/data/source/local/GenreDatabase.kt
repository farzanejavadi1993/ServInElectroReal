package com.example.servinelectroreal.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GenreLocal::class], version = 1)
abstract class GenreDatabase : RoomDatabase() {
    abstract fun getGenreDao(): GenreDao
}