package com.example.photospoc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photospoc.repository.PhotoRepository

class PhotosViewModel : ViewModel() {

    val photos = MutableLiveData<List<Photo>>()
    private val photoRepository = PhotoRepository()

    fun getPhotos() {
        photos.value = photoRepository.getPhotos()
    }

}