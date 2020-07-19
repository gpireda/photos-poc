package com.example.photospoc.view.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.photospoc.Photo
import com.example.photospoc.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo_row.view.*

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(photo: Photo) {
        itemView.title_text_view.text = photo.title
        loadImage(photo.thumbnailUrl)
    }

    private fun loadImage(url: String) {
        val imageView = itemView.findViewById<ImageView>(R.id.thumbnail_image)
        Picasso.get().load(url).into(imageView)
    }

}