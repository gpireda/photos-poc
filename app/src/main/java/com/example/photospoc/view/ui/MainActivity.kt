package com.example.photospoc.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photospoc.Photo
import com.example.photospoc.PhotosViewModel
import com.example.photospoc.R

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
        viewModel.photos.observe(this, Observer<List<Photo>> { configureRecyclerView() })
    }

    private fun configureRecyclerView() {
        findViewById<RecyclerView>(R.id.photos_recycler_view).apply {
            adapter = PhotosAdapter() { item ->
                val intent = PhotoDetailsActivity.getIntent(this@MainActivity)
                intent.putExtra("PHOTO_DETAILS_INTENT", item.title)

                startActivity(intent)
            }
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}