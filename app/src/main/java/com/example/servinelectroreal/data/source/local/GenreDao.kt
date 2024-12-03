package com.example.servinelectroreal.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenreLocal(genresLocal: GenreLocal)

    @Query("SELECT * FROM genre_table")
    fun getGenresLocal(): Flow<List<GenreLocal>>

    @Query("SELECT COUNT(*) FROM genre_table")
     fun sizeGenresLocal(): Int

}