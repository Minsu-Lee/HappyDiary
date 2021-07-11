package com.hackathon.happydiary.view.splash.ui

import android.app.Activity
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import com.hackathon.happydiary.extensions.viewPager2
import com.hackathon.happydiary.view.component.SquareImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class SplashUI: AnkoComponent<Activity> {

    lateinit var vp: ViewPager2

    lateinit var ind01: SquareImageView
    lateinit var ind02: SquareImageView
    lateinit var ind03: SquareImageView

    lateinit var contentTv: TextView

    lateinit var mKakaoLoginBtn: LinearLayout

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        constraintLayout {

            id = R.id.splash_parent
            lparams(width= matchParent, height= matchParent)
            // backgroundResource = R.drawable.bg_splash_unicorn

            vp = viewPager2 {
                orientation = ViewPager2.ORIENTATION_HORIZONTAL
                setPageTransformer(MarginPageTransformer(0))
            }.lparams(width= matchParent, height= matchParent)

            linearLayout {
                id = R.id.splash_indicator
                orientation = LinearLayout.HORIZONTAL

                ind01 = squareImageView(R.drawable.ic_splash_indicator) {
                }.lparams(width= dip(10)) {
                    rightMargin = dip(10)
                }

                ind02 = squareImageView(R.drawable.ic_splash_indicator) {
                }.lparams(width= dip(10)) {
                    rightMargin = dip(10)
                }

                ind03 = squareImageView(R.drawable.ic_splash_indicator) {
                }.lparams(width= dip(10))

            }.lparams(width= wrapContent, height= dip(10)) {
                topMargin = dip(60)
                horizontalMargin = dip(40)
                topToTop = R.id.splash_parent
                leftToLeft = R.id.splash_parent
            }

            contentTv = textView("당신만이\n누리고 있는 행복을\n붙잡아 기록해보세요.") {

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
                horizontalMargin = dip(40)
                bottomMargin = dip(40)
                bottomToBottom = R.id.splash_parent
            }

        }
    }
}