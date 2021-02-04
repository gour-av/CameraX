package com.masai_technology.cameraapp.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.masai_technology.cameraapp.viewmodel.ListImageViewModel
/***
 * This ViewModelFactory is used when an instance of viewmodel is required
 */

class ListImageViewModelFactory(private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListImageViewModel::class.java)) {
            return ListImageViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
    }
