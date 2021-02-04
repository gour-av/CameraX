package com.masai_technology.cameraapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.cameraapp.R
import com.masai_technology.cameraapp.database.ImageAlbum
import com.masai_technology.cameraapp.listener.ItemClickListener
import com.masai_technology.cameraapp.viewholder.ImageViewHolder

class ImageAdapter(private var ModelList : List<ImageAlbum>,
                   private val itemClickListener: ItemClickListener
):
    RecyclerView.Adapter<ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ImageViewHolder(view,itemClickListener)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val dataModel = ModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
       return ModelList.size
    }
    fun updateList(modelList: List<ImageAlbum>) {
        ModelList = modelList
        notifyDataSetChanged()
    }

}