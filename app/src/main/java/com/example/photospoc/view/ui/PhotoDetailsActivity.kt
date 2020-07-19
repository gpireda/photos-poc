package com.example.photospoc.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photospoc.R
import com.example.photospoc.constants.PhotoConstants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photo_details.*

class PhotoDetailsActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PhotoDetailsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)

        intent.extras?.let { setFromExtras(it) }
    }

    private fun setFromExtras(extras: Bundle) {
        with(extras) {
            get(PhotoConstants.INTENT.PHOTO_TITLE).let {
                photo_details_text_view.text = "$it"
            }

            get(PhotoConstants.INTENT.PHOTO_URL).let {
                Picasso.get().load(it.toString()).into(photo_image_view)
            }
        }
    }

}