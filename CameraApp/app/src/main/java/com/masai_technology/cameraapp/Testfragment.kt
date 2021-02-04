package com.masai_technology.cameraapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.masai_technology.cameraapp.activities.MainActivity
import com.masai_technology.cameraapp.database.Directory
import com.masai_technology.cameraapp.viewmodel.ImageViewModel
import com.masai_technology.cameraapp.viewmodelfactory.ImageViewModelFactory
import kotlinx.android.synthetic.main.fragment_testfragment.*

/***
 * In this we are creating the album name (directory name) and inserting that album name into the room database
 */

class Testfragment : Fragment() {
    private lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * In this we are getting the instance of the ViewModel class
         */
        imageViewModel = ImageViewModelFactory(this.requireContext()).create(ImageViewModel::class.java)


            /***
             * In this handle click we are passing the album name to the MainActivity
             */

        val name = ed_album_name.text.toString()
        var id = 0;
        img_album_button.setOnClickListener(View.OnClickListener {

            val directory = Directory(id, name)
            imageViewModel.insertperson(id, ed_album_name.text.toString())
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("directoryName",ed_album_name.text.toString())
            startActivity(intent)
        })


    }


}