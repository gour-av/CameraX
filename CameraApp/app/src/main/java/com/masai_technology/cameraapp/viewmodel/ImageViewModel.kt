package com.masai_technology.cameraapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.masai_technology.cameraapp.database.ImageAlbum
import com.masai_technology.cameraapp.repository.Repository

/***
 * This will list all the albums_name and insert into the database
 */
class ImageViewModel(private val context: Context): ViewModel() {
    private val repository = Repository()
    /**
     * This method is used to insert the data to the database
     */
   fun insertperson(id:Int,name:String){
       repository.insertperson(id,name,context)
   }


    }
