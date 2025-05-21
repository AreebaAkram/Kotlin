package com.example.test1.Song_MVVP.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song")
data class Songs(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "artist") val artist: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)


