package com.example.photospoc.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photospoc.R
import com.example.photospoc.repository.Photo
import com.example.photospoc.view.viewmodel.PhotosViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        PhotosViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observe()
        viewModel.getPhotos()
    }

    private fun observe() {
        viewModel.photos.observe(this, Observer<List<Photo>> { photos: List<Photo> ->
            configureRecyclerView(photos)
        })
    }

    private fun configureRecyclerView(photos: List<Photo>) {
        findViewById<RecyclerView>(R.id.photos_recycler_view).apply {
            adapter = PhotosAdapter(photos) { handleItemClick(it) }
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun handleItemClick(item: Photo) {
        val intent = PhotoDetailsActivity.getIntent(this@MainActivity)
        intent.putExtra("PHOTO_DETAILS_INTENT", item.title)

        startActivity(intent)
    }
}