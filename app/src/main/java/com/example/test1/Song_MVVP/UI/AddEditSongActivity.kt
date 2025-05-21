package com.example.test1.Song_MVVP.UI

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.test1.R
import com.example.test1.Song_MVVP.ViewModel.SongViewModel
import com.example.test1.Song_MVVP.model.Songs

class AddEditSongActivity : AppCompatActivity() {
    private val songViewModel: SongViewModel by viewModels()
    private var currentSong: Songs? = null
    private lateinit var edtSongTitle: EditText
    private lateinit var edtSongArtist: EditText
    private lateinit var edtSongImage: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_song)

        edtSongTitle = findViewById(R.id.EdtSongTitle)
        edtSongArtist = findViewById(R.id.EdtArtist)
        edtSongImage = findViewById(R.id.EdtSongImage)
        btnSave = findViewById(R.id.BtnSave)

        val songId = intent.getIntExtra("song_id", -1)

        if (songId != -1) {
            songViewModel.getSongById(songId).observe(this, Observer { songs ->
                songs?.let {
                    currentSong = it
                    edtSongTitle.setText(it.title)
                    edtSongArtist.setText(it.artist)
                    edtSongImage.setText(it.image)
                }
            })
        }

        btnSave.setOnClickListener {
            val title = edtSongTitle.text.toString().trim()
            val artist = edtSongArtist.text.toString().trim()
            val image = edtSongImage.text.toString().trim()

            if (title.isEmpty() || artist.isEmpty() || image.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (currentSong == null) {
                val newSong = Songs(title = title, artist = artist, image = image)
                songViewModel.insert(newSong)
            } else {
                val updatedSong = currentSong!!.copy(title = title, artist = artist, image = image)
                songViewModel.update(updatedSong)
            }

            finish()
        }
    }
}
