package com.example.test1.songs.UI

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test1.R
import com.example.test1.songs.adapter.SongAdopter
import com.example.test1.songs.model.Song
import com.example.test1.databinding.SongListScreenBinding

class songactivity : AppCompatActivity() {
    var binding : SongListScreenBinding?= null
    var songAdopter : SongAdopter? = null
    val songlist : MutableList<Song> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.song_list_screen)


        songlist.addAll(arrayListOf(
            Song(
                thumbnailUrl = "@drawables/cup.jpg",
                title = "happy",
                artist = "James",
                duration = "03:00"

            ),
            Song(
                thumbnailUrl = "cup.jpg",
                title = "Tired",
                artist = "Kalin",
                duration = "04:00"
            )
        ))
        songAdopter = SongAdopter()
        binding?.songRv?.adapter = songAdopter
        binding?.songRv?.layoutManager = LinearLayoutManager(this)
        songAdopter?.submitList(songlist)
        songAdopter?.notifyDataSetChanged()
    }

}