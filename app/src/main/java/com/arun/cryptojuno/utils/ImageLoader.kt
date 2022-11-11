package com.arun.cryptojuno.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader {

    fun loadImage(imageView : ImageView,imageUrl : String){
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(android.R.drawable.ic_menu_compass)
            .error(android.R.drawable.ic_menu_close_clear_cancel)
            .centerCrop()
            .into(imageView)
    }

}