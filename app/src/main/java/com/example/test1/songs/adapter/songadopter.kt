package com.example.test1.songs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test1.songs.model.Song
import com.example.test1.databinding.SongRowDesignBinding
import androidx.recyclerview.widget.DiffUtil

class SongAdopter (var deleteProductCallBack: (String) -> Unit) : ListAdapter <Song, SongAdopter.SongViewHolder> (diffChecker) {



    inner class SongViewHolder(var songRowDesignBinding: SongRowDesignBinding): RecyclerView.ViewHolder(songRowDesignBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val songRowDesignBinding : SongRowDesignBinding  = SongRowDesignBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
         return SongViewHolder(songRowDesignBinding = songRowDesignBinding)

    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val dataitem = getItem(position)
        holder.songRowDesignBinding.song = dataitem

        holder.SongRowDesignBinding.DeleteBtn.setOnClickListener {
            deleteProductCallBack.invoke(dataitem.id)
        }

    }
}

val diffChecker =  object: DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return false
    }

}