package com.masai_technology.cameraapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.masai_technology.cameraapp.database.ImageAlbum
import com.masai_technology.cameraapp.repository.ListRepository
import com.masai_technology.cameraapp.repository.Repository
/**
 * This will fetch the list of album_name from database and notify the activity with the help of
 * live data
 */
class ListImageViewModel(private val context: Context):ViewModel() {
    private val repository = ListRepository(context)

    fun fetchAllAlbums() : LiveData<List<ImageAlbum>> {
        return repository.fetchAlbumsFromDatabase()
    }
}