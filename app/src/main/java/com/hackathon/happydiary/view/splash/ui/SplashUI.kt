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
import org.jetbrains.anko.constraint.layout.constraintLayout

class SplashUI: AnkoComponent<Activity> {

    lateinit var mKakaoLoginBtn: LinearLayout

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        constraintLayout {

            id = R.id.splash_parent
            lparams(width= matchParent, height= matchParent)
            backgroundResource = R.drawable.bg_splash_unicorn
            topPadding = dip(60)
            bottomPadding = dip(40)
            horizontalPadding = dip(40)

            linearLayout {
                id = R.id.splash_indicator
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
                topToTop = R.id.splash_parent
                leftToLeft = R.id.splash_parent
            }

            textView("당신만이\n누리고 있는 행복을\n붙잡아 기록해보세요.") {

                typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_extra_bold)
                setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.splash_content_text_size))
                textColor = Color.parseColor("#1A1A1A")
                setLineSpacing(resources.getDimension(R.dimen.splash_content_text_line_height), 1.0f)
                gravity = Gravity.CENTER_VERTICAL

            }.lparams(width= wrapContent, height= wrapContent) {
                topMargin = dip(20)
                topToBottom = R.id.splash_indicator
                leftToLeft = R.id.splash_indicator
            }

            mKakaoLoginBtn = linearLayout {
                id = R.id.splash_kakao_btn
                orientation = LinearLayout.HORIZONTAL
                backgroundResource = R.drawable.bg_radius10_kakao
                gravity = Gravity.CENTER

                imageView(R.drawable.ic_login_kakao) {
                }.lparams(width= dip(18), height= dip(16)) {
                    rightMargin = dip(4)
                }

                textView("카카오 로그인") {

                    typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.login_text_size))
                    setLineSpacing(resources.getDimension(R.dimen.login_text_line_height), 1.0f)
                    textColor = Color.parseColor("#222222")
                    gravity = Gravity.CENTER

                }.lparams(width= wrapContent, height= wrapContent)

           }.lparams(width= matchParent, height= wrapContent) {
                bottomToBottom = R.id.splash_parent
            }

        }
    }
}