package com.example.win27

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.CountDownTimer
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

object SetBackgroundImage {
    fun setImage(constraintLayout: ConstraintLayout, context: Context){
        Glide.with(context)
            .asDrawable()
            .load("http://49.12.202.175/win27/background.jpg")
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    constraintLayout.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }
}