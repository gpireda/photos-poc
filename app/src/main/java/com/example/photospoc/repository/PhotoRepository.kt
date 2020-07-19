package com.example.photospoc.repository

import com.example.photospoc.Photo

class PhotoRepository {

    fun getPhotos(): List<Photo> = getPhotosMock()

    private fun getPhotosMock(): List<Photo> {
        val tempList = arrayListOf<Photo>()

        for (i in 1..40) {
            tempList.add(
                Photo(
                    title = "Title $i",
                    thumbnailUrl = "https://via.placeholder.com/150/92c952"
                )
            )
        }

        return tempList
    }

}