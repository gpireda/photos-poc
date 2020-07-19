package com.example.photospoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
            adapter = PhotosAdapter()
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}