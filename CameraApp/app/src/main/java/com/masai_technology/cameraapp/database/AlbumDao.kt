package com.masai_technology.cameraapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/***
 * This  is the interface class (Dao-data access object ) where we write the queries
 */
@Dao
interface AlbumDao {


    @Insert
     fun insertAlbumName(imageAlbum: ImageAlbum)

    @Query("Select * from model")
    fun fetchAlbumNames() : LiveData<List<ImageAlbum>>
}