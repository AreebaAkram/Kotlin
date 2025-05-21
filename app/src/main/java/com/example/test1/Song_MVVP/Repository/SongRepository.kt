package com.example.test1.Song_MVVP.Repository

import androidx.lifecycle.LiveData
import com.example.test1.DAO.SongDao
import com.example.test1.Song_MVVP.model.Songs

class SongRepository(private val songDao: SongDao) {
    val allSongs: LiveData<List<Songs>> = songDao.getAllSongs()

    suspend fun insert(song: Songs) {
        songDao.insert(List(1) { song })
    }

    suspend fun delete(song: Songs) {
        songDao.delete(song)
    }

    suspend fun update(song: Songs) = songDao.update(song)

    suspend fun getSongById(songId: Int): Songs? {
        return songDao.getSongById(songId)
    }
}
