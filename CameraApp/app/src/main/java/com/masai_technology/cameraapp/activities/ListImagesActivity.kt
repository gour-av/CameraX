package com.masai_technology.cameraapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.masai_technology.cameraapp.R
import com.masai_technology.cameraapp.adapter.ImageListAdapter
import com.masai_technology.cameraapp.listener.ItemImageClickListener
import kotlinx.android.synthetic.main.activity_list_images.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.File

/***
 * In this Activity we are populating the List of Images with the help of recyclerView
 */
class ListImagesActivity : AppCompatActivity(),ItemImageClickListener {
    lateinit var listFile: Array<File>
    var listofiles=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_images)
        /***
         * In this we are getting message/data of the directory name via intent
         */
        val name=intent.getStringExtra("data")
        if (name != null) {
            getFromSdcard(name)
        }

    }

    /***
     * In this method we are trying to get the Image(file path) which is saved in the external Storage of the mobile device
     */
    fun getFromSdcard(root: String) {
        CoroutineScope(IO).launch {
            val file=externalMediaDirs.firstOrNull()?.let { File(it,root) }
            if(file?.isDirectory!!){
                listFile=file.listFiles()!!
                for (element in listFile){
                    listofiles.add(element.absolutePath)
                }
            }
        }.invokeOnCompletion {
            setAdapter()
        }
    }

    /***
     * OverHere we are setting up the recyclerAdapter
     */
    fun setAdapter(){
        CoroutineScope(Dispatchers.Main).launch {
            val gridLayoutManager= GridLayoutManager(this@ListImagesActivity, 3)
            val adapter=ImageListAdapter(listofiles,this@ListImagesActivity)
            recycler_view_list.adapter=adapter
            recycler_view_list.layoutManager=gridLayoutManager
        }
    }

    /***
     * In this Click we can handle the images which is being shown into the directory and can preview the image on click of the particular image
     */
    override fun onItemClicked(position: Int, p:String) {
             val intent = Intent(this, PreviewActivity::class.java)
               intent.putExtra("display_image",p)
                 startActivity(intent)
    }
}