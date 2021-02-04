package com.masai_technology.cameraapp.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.masai_technology.cameraapp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/***
 * In this Activity with the help of CameraX library we are capturing the images
 */
class MainActivity : AppCompatActivity() {
    var camera: Camera? = null
    var preview: Preview? = null
    var imageCapture: ImageCapture? = null
     val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /***
         * In this we are Taking the permissions to open the camera
         */
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PERMISSION_GRANTED) {
            Start_Camera()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 0)
        }
        btn_capture.setOnClickListener(View.OnClickListener {
            Take_Images()
        })
        btn_show_images.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AlbumActivity::class.java)
            startActivity(intent)
        })

    }

    /***
     * In this I am getting the directory name(album name ) via intent(Overhere it will pass the media directory from external
     * storage of the device
     */
    private fun getOutputDirectory(): File {
        val directoryName= intent.getStringExtra("directoryName")
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, directoryName).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }

    /***
     * Overhere we are saving the images with the help of Current TimeStamp
     */
    private fun Take_Images() {
        //save_photo
        val mediaDir =File(
            getOutputDirectory(), SimpleDateFormat(
                FILENAME_FORMAT, Locale.US
            ).format(System.currentTimeMillis()) + ".jpg"
        )

        /***
         * Overhere we are defining were we will save our output file
         */
        val output_res = ImageCapture.OutputFileOptions.Builder(mediaDir).build()
        imageCapture?.takePicture(
                output_res,
                ContextCompat.getMainExecutor(this),
                object : ImageCapture.OnImageSavedCallback {
                    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {

                    }

                    override fun onError(exception: ImageCaptureException) {
                        Toast.makeText(this@MainActivity, "Image is Not Saved", Toast.LENGTH_SHORT).show()
                    }

                })

    }

    /***
     * Overhere we are Taking permission from the user to open the Camera
     */
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PERMISSION_GRANTED) {
            Start_Camera()
        } else {
            Toast.makeText(this, "Accept the Permission For camera", Toast.LENGTH_SHORT).show()
        }
    }

    /***
     * Overhere we are binding the camera with the app lifecycle and also previewing the camera
     */
    private fun Start_Camera() {
        //startcamera
        /***
         * This one will tell us that if the camera has been binded with the app lifecycle or not
         */
        val cameraProvider = ProcessCameraProvider.getInstance(this)
        cameraProvider.addListener(Runnable {
            val cameraProvider_new = cameraProvider.get()
            preview = Preview.Builder().build()
            preview?.setSurfaceProvider(camera_view.createSurfaceProvider(camera?.cameraInfo))
            imageCapture = ImageCapture.Builder().build()
            val camera_selector = CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build()
            cameraProvider_new.unbindAll()
            camera = cameraProvider_new.bindToLifecycle(this, camera_selector, preview, imageCapture)
        }, ContextCompat.getMainExecutor(this))
    }



    }
