package com.hackathon.happydiary.adapter.splash.holder

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hackathon.happydiary.R
import com.hackathon.happydiary.adapter.splash.ui.SplashImageUI
import com.hackathon.happydiary.base.BaseViewHolder

class SplashViewHolder(parent: ViewGroup, val imageUi: SplashImageUI): BaseViewHolder(parent, imageUi) {

    fun onBind(position: Int) = with(imageUi) {
        Glide.with(ctx)
            .load(R.drawable.bg_splash_gradation)
            .into(bgIv)

        Glide.with(ctx)
            .load(R.drawable.ic_splash_left_top_02)
            .into(leftTopIv)

        Glide.with(ctx)
            .load(R.drawable.ic_splash_right_top_02)
            .into(rightTopIv)

        Glide.with(ctx)
            .load(R.drawable.ic_splash_bottom_02)
            .into(bottomIv)

        Glide.with(ctx)
            .load(R.drawable.ic_unicorn_02)
            .into(unicornIv)
    }
}