package com.example.test1.songs.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.State_Management.system_state
import com.example.test1.databinding.AddOrRemoveBinding
import com.example.test1.songs.model.Song


class addordelete : AppCompatActivity() {
    var binding: AddOrRemoveBinding? = null
    var song: Song = Song()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddOrRemoveBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (system_state.Song != null) {
            this@addordelete.song = system_state.Song!!
            binding?.songIdEditText?.isEnabled = false
        }
        binding?. song = this@addordelete.song

        binding?.submitbtn?.setOnClickListener {
            system_state.Song = song
            finish()
        }
    }
}



}