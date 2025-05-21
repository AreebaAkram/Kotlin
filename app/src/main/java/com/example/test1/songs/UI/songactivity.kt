package com.example.test1.songs.UI

import android.os.Bundle
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
                thumbnailUrl = "https://images.unsplash.com/photo-123456789.jpg",
                title = "Replay",
                artist = "Iyaz",
                duration = "03:00"

            ),
            Song(
                thumbnailUrl = "cup.jpg",
                title = "Grenade",
                artist = "Bruno Mard",
                duration = "04:00"
            ),
            Song(
                thumbnailUrl = "cup.jpg",
                title = "Him & I",
                artist = "G-Eazy",
                duration = "04:00"
            ),
            Song(
                thumbnailUrl = "data:image/jpeg;base64,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",
                title = "The Hills",
                artist = "The Weeknd",
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