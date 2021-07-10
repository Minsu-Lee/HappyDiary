package com.hackathon.happydiary.view.splash.ui

import android.app.Activity
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import org.jetbrains.anko.*

class SplashUI: AnkoComponent<Activity> {

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent)
            backgroundResource = R.drawable.bg_splash_unicorn

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                squareImageView(R.drawable.ic_splash_indicator) {
                }.lparams(width= dip(10)) {
                    rightMargin = dip(10)
                }

                squareImageView(R.drawable.ic_splash_indicator) {
                }.lparams(width= dip(10)) {
                    rightMargin = dip(10)
                }

                squareImageView(R.drawable.ic_splash_indicator) {
                }.lparams(width= dip(10))

            }.lparams(width= wrapContent, height= dip(10)) {
                topMargin = dip(60)
                leftMargin = dip(40)
                bottomMargin = dip(20)
            }

            textView("당신만이\n누리고 있는 행복을\n붙잡아 기록해보세요.") {

                typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_bold)
                setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.splash_content_text_size))
                textColor = Color.parseColor("#1A1A1A")
                gravity = Gravity.CENTER_VERTICAL

            }.lparams(width= wrapContent, height= wrapContent) {
                leftMargin = dip(40)
            }

            view { backgroundColor = android.R.color.transparent }.lparams(width= dip(1), height= wrapContent, weight = 1f)

            linearLayout {
                backgroundResource = R.drawable.bg_radius10_ff
                gravity = Gravity.CENTER

                textView("시작하기") {

                    typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.splash_start_text_size))
                    textColor = Color.parseColor("#C174FD")
                    gravity = Gravity.CENTER

                }.lparams(width= wrapContent, height= wrapContent)

           }.lparams(width= matchParent, height= wrapContent) {
                horizontalMargin = dip(40)
                bottomMargin = dip(40)
            }

        }
    }
}