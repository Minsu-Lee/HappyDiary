package com.hackathon.happydiary.adapter.splash.ui

import android.graphics.Color
import android.graphics.Point
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import org.jetbrains.anko.*

class SplashEndImageUI(var deviceSize: Point): AnkoComponent<ViewGroup> {

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

                val rightTopWidth = ((deviceSize.x * dip(82)) / dip(360))
                val rightTopHeight = ((deviceSize.y * dip(187)) / dip(640))
                val rightTopTopMargin = ((deviceSize.y * dip(40)) / dip(640))
                rightTopIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= rightTopWidth, height= rightTopHeight) {
                    alignParentTop()
                    alignParentRight()
                    topMargin = rightTopTopMargin
                }

                bottomIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= matchParent, height= wrapContent) {
                    alignParentBottom()
                }

                val unicornWidth = (deviceSize.x * dip(303)) / dip(360)
                val unicornHeight = ((deviceSize.y * dip(266)) / dip(640))
                val unicornLeftMargin = (deviceSize.x * dip(40)) / dip(360)
                val unicornBottomMargin = ((deviceSize.y * dip(20)) / dip(640))
                unicornIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= unicornWidth, height= unicornHeight) {
                    leftMargin = unicornLeftMargin
                    bottomMargin = unicornBottomMargin
                    alignParentBottom()
                    alignParentRight()
                }
            }
        }
    }
}