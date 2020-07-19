package com.example.photospoc.repository

import com.example.photospoc.repository.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository {

    private val apiClient = ApiClient.instance

    fun getPhotos(handleSuccess: (List<Photo>) -> Unit) {
        val call = apiClient.list()

        call.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    val photos = response.body()?.let { it?.map { photo -> photo } } ?: listOf()
                    handleSuccess(photos)
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
            }
        })
    }

}