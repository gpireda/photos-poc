package com.example.photospoc.repository.remote

import com.example.photospoc.repository.Photo
import retrofit2.Call
import retrofit2.http.GET

interface PhotosService {
    @GET("photos")
    fun list(): Call<List<Photo>>
}