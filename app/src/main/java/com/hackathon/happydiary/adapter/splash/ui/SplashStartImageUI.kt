package com.hackathon.happydiary.adapter.splash.ui

import android.graphics.Color
import android.graphics.Point
import android.view.ViewGroup
import android.widget.ImageView
import org.jetbrains.anko.*

class SplashStartImageUI(var deviceSize: Point): AnkoComponent<ViewGroup> {

    lateinit var bgIv: ImageView
    lateinit var rightTopIv: ImageView
    lateinit var bottomIv: ImageView
    lateinit var unicornIv: ImageView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            lparams(width= matchParent, height= matchParent) {
                backgroundColor = Color.TRANSPARENT

                bgIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= matchParent, height= matchParent)

                val rightTopWidth = ((deviceSize.x * dip(226)) / dip(360))
                val rightTopHeight = ((deviceSize.y * dip(221)) / dip(640))
                rightTopIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= rightTopWidth, height= rightTopHeight) {
                    alignParentTop()
                    alignParentRight()
                }

                bottomIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= matchParent, height= wrapContent) {
                    alignParentBottom()
                }

                val unicornLeftMargin = (deviceSize.x * ctx.dip(68)) / ctx.dip(360)
                val unicornBottomMargin = ((deviceSize.y * dip(120)) / dip(640))
                unicornIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= wrapContent, height= wrapContent) {
                    leftMargin = unicornLeftMargin
                    bottomMargin = unicornBottomMargin
                    alignParentBottom()
                    alignParentLeft()
                }

            }
        }
    }
}