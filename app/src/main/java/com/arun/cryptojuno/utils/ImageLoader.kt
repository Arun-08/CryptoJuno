package com.arun.cryptojuno.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt


class ImageLoader {
    fun loadImage(imageView : ImageView,imageUrl : String){
        // Remote image url not loading so i given random url
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_compass)
            .error(android.R.drawable.ic_menu_close_clear_cancel)

        Glide.with(imageView.context)
            .load(imageList[Random().nextInt(2+0+1)+1])
            .apply(options)
            .into(imageView)
    }

    private val imageList : ArrayList<String> = arrayListOf(
        "https://s2.coinmarketcap.com/static/img/coins/200x200/1.png",
        "https://cloudfront-us-east-1.images.arcpublishing.com/coindesk/ZJZZK5B2ZNF25LYQHMUTBTOMLU.png",
        "https://s2.coinmarketcap.com/static/img/coins/200x200/3408.png",
        "https://s2.coinmarketcap.com/static/img/coins/200x200/5805.png"
    )

}