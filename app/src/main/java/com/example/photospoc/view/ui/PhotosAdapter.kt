package com.example.photospoc.view.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photospoc.R
import com.example.photospoc.repository.Photo

class PhotosAdapter(
    private val photos: List<Photo>,
    private val listener: (Photo) -> Unit
) :
    RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_row, parent, false)

        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = photos.count()

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]

        holder.bind(photo)
        holder.itemView.setOnClickListener { listener(photo) }
    }
}