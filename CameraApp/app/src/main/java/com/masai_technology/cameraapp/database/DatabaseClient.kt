package com.masai_technology.cameraapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.masai_technology.cameraapp.converter.Converters

/***
 * This is the DatabaseClient class from were we manages our(local storage) room database
 */
@Database(entities = [ImageAlbum::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseClient : RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseClient? = null

        fun getDatabase(context: Context): DatabaseClient =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DatabaseClient::class.java, "album_database"
            ).build()
    }

}