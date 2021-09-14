package com.pakt_games.foodinfobook.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pakt_games.foodinfobook.R

fun ImageView.downloadImage(url:String?,placeholder:CircularProgressDrawable)
{
    //if  image to late coming this screen
    val options=RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)

    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}

// create progressBar for PlaceHolder
fun createPlaceholder(contex:Context):CircularProgressDrawable
{
    return CircularProgressDrawable(contex).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}
