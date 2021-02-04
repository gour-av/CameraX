package com.masai_technology.cameraapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.cameraapp.R
import com.masai_technology.cameraapp.listener.ItemImageClickListener
import com.masai_technology.cameraapp.viewholder.DisplayImageViewHolder

class ImageListAdapter(val list:List<String>,val itemImageClickListener: ItemImageClickListener):RecyclerView.Adapter<DisplayImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_images,parent,false)
        return DisplayImageViewHolder(view,itemImageClickListener)
    }

    override fun onBindViewHolder(holder: DisplayImageViewHolder, position: Int) {
        val data_model = list[position]
        holder.setdata(data_model)
    }

    override fun getItemCount(): Int {
     return list.size
    }
}