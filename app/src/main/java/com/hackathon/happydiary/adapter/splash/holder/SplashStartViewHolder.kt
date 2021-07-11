package com.hackathon.happydiary.adapter.splash.holder

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hackathon.happydiary.R
import com.hackathon.happydiary.adapter.splash.ui.SplashStartImageUI
import com.hackathon.happydiary.base.BaseViewHolder

class SplashStartViewHolder(parent: ViewGroup, val imageUi: SplashStartImageUI): BaseViewHolder(parent, imageUi) {

    fun onBind(position: Int) = with(imageUi) {

        Glide.with(ctx)
            .load(R.drawable.bg_splash_gradation)
            .into(bgIv)

        Glide.with(ctx)
            .load(R.drawable.ic_splash_right_top_01)
            .into(rightTopIv)

        Glide.with(ctx)
            .load(R.drawable.ic_splash_bottom_01)
            .into(bottomIv)

        Glide.with(ctx)
            .load(R.drawable.ic_unicorn_01)
            .into(unicornIv)
    }
}