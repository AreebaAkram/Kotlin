package com.example.test1.Song_MVVP.UI

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.test1.R
import com.example.test1.Song_MVVP.Adapter.SongRVAdapter
import com.example.test1.Song_MVVP.ViewModel.SongViewModel
import com.example.test1.Song_MVVP.model.Songs

class MainActivity : AppCompatActivity() {
    private lateinit var songRV: RecyclerView
    private lateinit var addFAB: FloatingActionButton
    private val songViewModel: SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainn)

        songRV = findViewById(R.id.songsRV)
        addFAB = findViewById(R.id.idFAB)

        val adapter = SongRVAdapter(emptyList(),
            onEditClick = { song -> openEditSongScreen(song) },
            onDeleteClick = { song -> songViewModel.delete(song) })
        songRV.adapter = adapter
        songRV.layoutManager = LinearLayoutManager(this)


        songViewModel.allSongs.observe(this, Observer { song ->
            adapter.updateList(song)
        })


        addFAB.setOnClickListener {
            val intent = Intent(this, AddEditSongActivity::class.java)
            startActivity(intent)
        }
    }


    private fun openEditSongScreen(song: Songs) {
        val intent = Intent(this, AddEditSongActivity::class.java)

        intent.putExtra("song_id", song.id)
        startActivity(intent)
    }
}
