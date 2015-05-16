package com.ordonteam.home4jars.view.common

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.R
import groovy.transform.CompileStatic

@CompileStatic
final class FlipImageView extends ImageView implements View.OnClickListener{
    FlipImageView(Context context) {
        super(context)
        onClickListener = this
    }

    FlipImageView(Context context, AttributeSet attrs) {
        super(context, attrs)
        onClickListener = this
    }

    FlipImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
        onClickListener = this
    }

    FlipImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes)
        onClickListener = this
    }

    @Override
    void onClick(View v) {
        flip()
    }

    void flip() {
        Animation
        Glide.with(context).load(R.drawable.park_back).crossFade(2000).into(this)
    }
}