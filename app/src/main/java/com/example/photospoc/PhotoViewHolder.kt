package com.example.photospoc

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.photo_row.view.*

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(photo: Photo) {
        itemView.title_text_view.text = photo.title
    }

}