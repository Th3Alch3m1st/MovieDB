package com.neugelb.core.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.chip.Chip
import com.neugelb.core.R
import com.neugelb.core.glide.GlideApp

/**
 * Created By Rafiqul Hasan
 */

@BindingAdapter("image_url")
fun ImageView.loadImage(url: String?) {
	GlideApp.with(this)
		.load(url)
		.placeholder(R.drawable.ic_movie_placeholder)
		.error(R.drawable.ic_movie_placeholder)
		.into(this)
}