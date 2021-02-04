package com.masai_technology.cameraapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.masai_technology.cameraapp.database.DatabaseClient
import com.masai_technology.cameraapp.database.ImageAlbum

/***
 * This is a `M` layer in the `MVVM` architecture where we are the doing the fetching operation
 */

class ListRepository(private val context: Context) {
    fun fetchAlbumsFromDatabase(): LiveData<List<ImageAlbum>> {

        return DatabaseClient.getDatabase(context).albumDao().fetchAlbumNames()
    }
}