package com.masai_technology.cameraapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.masai_technology.cameraapp.database.DatabaseClient
import com.masai_technology.cameraapp.database.ImageAlbum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is a `M` layer in the `MVVM` architecture where we are the doing the insertion operation
 */
class Repository() {
    fun insertperson(id: Int, name: String, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {

            val album = ImageAlbum(id, album_name = name, time_stamp = System.currentTimeMillis())
           DatabaseClient.getDatabase(context).albumDao().insertAlbumName(album)
        }
    }

}