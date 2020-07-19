package com.example.photospoc.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photospoc.repository.Photo
import com.example.photospoc.repository.PhotoRepository

class PhotosViewModel : ViewModel() {

    val photos = MutableLiveData<List<Photo>>()
    private val photoRepository = PhotoRepository()

    fun getPhotos() {
        photoRepository.getPhotos { list -> photos.value = list }
    }

}