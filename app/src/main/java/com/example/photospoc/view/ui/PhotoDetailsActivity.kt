package com.example.photospoc.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photospoc.R
import kotlinx.android.synthetic.main.activity_photo_details.*

class PhotoDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)

        intent.extras?.get("PHOTO_DETAILS_INTENT").let {
            photo_details_text_view.text = "PhotoDetailsActivity - ${it.toString()}"
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PhotoDetailsActivity::class.java)
        }
    }

}