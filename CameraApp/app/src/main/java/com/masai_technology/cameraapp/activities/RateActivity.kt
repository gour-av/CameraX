package com.masai_technology.cameraapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.masai_technology.cameraapp.R
import kotlinx.android.synthetic.main.activity_rate.*

/***
 * In this activity we can give ratings (star)
 */
class RateActivity : AppCompatActivity() {
    var star:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        btn_submit.setOnClickListener(View.OnClickListener {
            star = rating_star.rating.toString()
            Toast.makeText(this,star+"Stars",Toast.LENGTH_SHORT).show()
        })
    }
}