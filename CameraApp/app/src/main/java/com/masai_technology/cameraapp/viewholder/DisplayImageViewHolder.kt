package com.masai_technology.cameraapp.viewholder

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.cameraapp.listener.ItemImageClickListener
import kotlinx.android.synthetic.main.activity_list_images.view.*
import kotlinx.android.synthetic.main.item_images.view.*

class DisplayImageViewHolder(var view: View,private val itemImageClickListener: ItemImageClickListener): RecyclerView.ViewHolder(view) {
    fun setdata(p:String){
        view.apply {
            val bitmap= BitmapFactory.decodeFile(p)
            img_path.setImageBitmap(bitmap)
            img_path.setOnClickListener(View.OnClickListener {
                itemImageClickListener.onItemClicked(adapterPosition,p)
            })


        }
    }
}