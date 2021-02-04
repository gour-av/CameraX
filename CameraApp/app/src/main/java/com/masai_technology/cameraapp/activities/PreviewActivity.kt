package com.masai_technology.cameraapp.activities

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai_technology.cameraapp.R
import kotlinx.android.synthetic.main.activity_preview.*

/***
 * In this Activity we are previewing the image by decoding the file to bitmap
 */
class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val preview_image = intent.getStringExtra("display_image")
        val myBitmap = BitmapFactory.decodeFile(preview_image)
        img_display.setImageBitmap(myBitmap)

    }
}