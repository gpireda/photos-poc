package com.example.photospoc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photospoc.repository.PhotoRepository

class PhotosAdapter(private val photos: List<Photo> = PhotoRepository().getPhotos()) :
    RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_row, parent, false)

        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = photos.count()

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }
}