package com.example.test1.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.test1.Song_MVVP.model.Songs

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(song: List<Songs>)

    @Delete
    suspend fun delete(song: Songs)

    @Query("SELECT * FROM song ORDER BY id ASC")
    fun getAllSongs(): LiveData<List<Songs>>

    @Query("SELECT * FROM song WHERE id = :songId LIMIT 1")
    suspend fun getSongById(songId: Int): Songs?

    @Update
    suspend fun update(song: Songs)
}
