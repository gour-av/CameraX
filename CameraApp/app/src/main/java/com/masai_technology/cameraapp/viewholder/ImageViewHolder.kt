package com.masai_technology.cameraapp.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.cameraapp.R
import com.masai_technology.cameraapp.database.ImageAlbum
import com.masai_technology.cameraapp.listener.ItemClickListener
import kotlinx.android.synthetic.main.item_layout.view.*

class ImageViewHolder(private val view: View,private val itemClickListener: ItemClickListener):RecyclerView.ViewHolder(view) {
    fun setData(dataModel: ImageAlbum) {
       view.apply {
           ivAlbum.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.pic_folder_icon))
           tvAlbumName.text = dataModel.album_name
           ivAlbum.setOnClickListener {
               itemClickListener.onItemClicked(dataModel.album_name)
           }
       }

    }


}