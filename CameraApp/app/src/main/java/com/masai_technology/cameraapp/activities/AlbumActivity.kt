package com.masai_technology.cameraapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.masai_technology.cameraapp.R
import com.masai_technology.cameraapp.adapter.ImageAdapter
import com.masai_technology.cameraapp.database.ImageAlbum
import com.masai_technology.cameraapp.listener.ItemClickListener
import com.masai_technology.cameraapp.viewmodel.ImageViewModel
import com.masai_technology.cameraapp.viewmodel.ListImageViewModel
import com.masai_technology.cameraapp.viewmodelfactory.ImageViewModelFactory
import com.masai_technology.cameraapp.viewmodelfactory.ListImageViewModelFactory
import kotlinx.android.synthetic.main.activity_album.*

/**
 * In this Activity we are Getting the Lists of Directory/Album by Populating it with the help of recyclerview
 */
class AlbumActivity : AppCompatActivity() ,ItemClickListener {

    private lateinit var list_imageViewModel: ListImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        /**
         * In this we are getting the instance of the viewModel class
         */
        list_imageViewModel = ListImageViewModelFactory(this).create(ListImageViewModel::class.java)
        /**
         * This method is used to observe the live data changes which we are fetching(Stored) from the database
         */
        list_imageViewModel.fetchAllAlbums().observe(this, Observer {
            it?.let {
                setRecyclerAdapter(it)
            }
        })


    }

    /**
     * OverHere we are Setting the recycler Adapter
     */
    private fun setRecyclerAdapter(it: List<ImageAlbum>) {
        val gridLayoutManager = GridLayoutManager(this, 3)
        val imageadapter = ImageAdapter(it, this)
        recycler_view.apply {
            layoutManager = gridLayoutManager
            adapter = imageadapter

        }


    }

    /**
     * This handles clicks from recycler view when directory is clicked and it will show all the images that belong to
     * the clicked directory
     */
    override fun onItemClicked(name: String) {
        val list_name = name
        val intent= Intent(this, ListImagesActivity::class.java)
        intent.putExtra("data",list_name)
        startActivity(intent)
    }


}

