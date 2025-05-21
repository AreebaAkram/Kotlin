package com.example.test1.Song_MVVP.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test1.R
import com.example.test1.Song_MVVP.model.Songs

class SongRVAdapter(
    private var songs: List<Songs>,
    private val onEditClick: (Songs) -> Unit,
    private val onDeleteClick: (Songs) -> Unit
) : RecyclerView.Adapter<SongRVAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val songTitle: TextView = itemView.findViewById(R.id.songTitle)
        val artistname: TextView = itemView.findViewById(R.id.songArtist)
        val songImage: ImageView = itemView.findViewById(R.id.songImage)
        val editButton: ImageView = itemView.findViewById(R.id.editButton)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.song_rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSong = songs[position]
        holder.songTitle.text = currentSong.title
        holder.artistname.text = currentSong.artist

//        Glide.with(holder.itemView.context).load(currentSong.image).into(holder.songImage)

        Glide.with(holder.itemView.context)
            .load(currentSong.image)
            .placeholder(R.drawable.baseline_add_alert_24)
            .error(R.drawable.baseline_remove_red_eye_24)
            .into(holder.songImage)

        holder.editButton.setOnClickListener {
            onEditClick(currentSong)
        }
        holder.deleteButton.setOnClickListener {
            onDeleteClick(currentSong)
        }

    }

    override fun getItemCount() = songs.size

    fun updateList(newList: List<Songs>) {
        songs = newList
        notifyDataSetChanged()
    }
}
