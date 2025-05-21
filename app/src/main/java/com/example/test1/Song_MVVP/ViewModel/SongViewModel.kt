package com.example.test1.Song_MVVP.ViewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.test1.DAO.SongDatabase
import com.example.test1.Song_MVVP.Repository.SongRepository
import com.example.test1.Song_MVVP.model.Songs

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SongRepository
    val allSongs: LiveData<List<Songs>>

    init {
        val songDao = SongDatabase.getDatabase(application).getSongDao()
        repository = SongRepository(songDao)
        allSongs = repository.allSongs
    }

    fun insert(song: Songs) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(song)
    }

    fun delete(song: Songs) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(song)
    }

    fun update(song: Songs) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(song)
    }

    fun getSongById(songId: Int): LiveData<Songs?> {
        val songLiveData = MutableLiveData<Songs?>()
        viewModelScope.launch(Dispatchers.IO) {
            val song = repository.getSongById(songId)
            songLiveData.postValue(song)
        }
        return songLiveData
    }

}
