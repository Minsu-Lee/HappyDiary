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

class SplashImageUI(var deviceSize: Point): AnkoComponent<ViewGroup> {

    lateinit var bgIv: ImageView
    lateinit var leftTopIv: ImageView
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


                val leftTopWidth = ((deviceSize.x * dip(122)) / dip(360))
                val leftTopHeight = ((deviceSize.y * dip(61)) / dip(640))
                leftTopIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= leftTopWidth, height= leftTopHeight) {
                    alignParentTop()
                    alignParentLeft()
                }

                val rightTopWidth = ((deviceSize.x * dip(82)) / dip(360))
                val rightTopHeight = ((deviceSize.y * dip(187)) / dip(640))
                val rightTopTopMargin = ((deviceSize.y * dip(61)) / dip(640))
                val rightTopRightMargin  = ((deviceSize.x * dip(33)) / dip(360))
                rightTopIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= rightTopWidth, height= rightTopHeight) {
                    alignParentTop()
                    alignParentRight()
                    topMargin = rightTopTopMargin
                    rightMargin = rightTopRightMargin
                }

                bottomIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= matchParent, height= wrapContent) {
                    alignParentBottom()
                }

                val unicornRightWidth = (deviceSize.x * dip(280)) / dip(360)
                val unicornBottomHeight = ((deviceSize.y * dip(264)) / dip(640))
                val unicornRightMargin = (deviceSize.x * dip(24)) / dip(360)
                val unicornBottomMargin = ((deviceSize.y * dip(197)) / dip(640))
                unicornIv = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(width= unicornRightWidth, height= unicornBottomHeight) {
                    rightMargin = unicornRightMargin
                    bottomMargin = unicornBottomMargin
                    alignParentBottom()
                    alignParentRight()
                }
            }
        }
    }
}