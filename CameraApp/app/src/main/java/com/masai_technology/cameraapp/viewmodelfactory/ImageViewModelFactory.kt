package com.masai_technology.cameraapp.viewmodelfactory

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.masai_technology.cameraapp.viewmodel.ImageViewModel

/***
 * This ViewModelFactory is used when an instance of viewmodel is required
 */
class ImageViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageViewModel::class.java)) {
            return ImageViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
    }
