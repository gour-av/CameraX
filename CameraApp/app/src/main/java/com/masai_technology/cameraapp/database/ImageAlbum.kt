package com.masai_technology.cameraapp.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * This is the model class of the database where we make columns for a particular table
 */
@Entity(tableName = "model")
data class ImageAlbum(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "album_id")
    var album_id: Int = 1,
    @ColumnInfo(name = "album_name")
    val album_name:String ,
    @ColumnInfo(name = "time_stamp")
    val time_stamp: Long ) {


}

