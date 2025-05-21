package com.example.test1.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test1.Song_MVVP.model.Songs

@Database(entities = [Songs::class], version = 1, exportSchema = false)
abstract class SongDatabase : RoomDatabase() {
    abstract fun getSongDao(): SongDao

    companion object {
        @Volatile
        private var INSTANCE: SongDatabase? = null

        fun getDatabase(context: Context): SongDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SongDatabase::class.java,
                    "song_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
