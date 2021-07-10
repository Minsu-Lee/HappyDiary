package com.hackathon.happydiary.view.diary.ui

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginLeft
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.design.textInputEditText
import org.jetbrains.anko.design.themedBottomNavigationView

class DiaryUI: AnkoComponent<Activity> {

    var num = 0
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            backgroundResource = R.drawable.bg_splash_unicorn

            linearLayout {
                orientation = LinearLayout.HORIZONTAL
                squareImageView(R.drawable.ic_back_btn) {
                    gravity = Gravity.CENTER
                }.lparams(width = dip(23), height = dip(30)) {
                    rightMargin = dip(18)
                    leftMargin = dip(18)
                    topMargin = dip(14)
                    bottomMargin = dip(14)
                }

                textView("${num}번째 행복") {
                    typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_bold)
                    setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        resources.getDimension(R.dimen.splash_content_text_size)
                    )
                    textColor = Color.parseColor("#1A1A1A")
                    gravity = Gravity.CENTER

                }.lparams(width = matchParent, height = matchParent) {
                    leftMargin = dip(95)
                }
            }.lparams(width = wrapContent, height = wrapContent) {
                topMargin = dip(40)
                bottomMargin = dip(18)
            }

            verticalLayout {
                backgroundResource = R.drawable.bg_diary_space
                gravity = Gravity.CENTER_HORIZONTAL
                textView("2021.07.09 (금)") {
                    typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                    setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        resources.getDimension(R.dimen.splash_start_text_size)
                    )
                    textColor = Color.parseColor("#999999")
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(20)
                    bottomMargin = dip(20)
                }

                linearLayout {
                    gravity = Gravity.LEFT
                    textView("오늘 하루는 어땠나요?") {
                        typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                        setTextSize(
                            TypedValue.COMPLEX_UNIT_PX,
                            resources.getDimension(R.dimen.splash_start_text_size)
                        )
                        textColor = Color.parseColor("#000000")
                        gravity = Gravity.CENTER_VERTICAL

                    }.lparams(width = matchParent, height = wrapContent){
                        rightMargin=dip(5)
                    }
                    button {
                        backgroundResource = R.drawable.ic_weather_rain
                    }.lparams(width = dip(30), height = dip(30))
                    imageButton(R.drawable.ic_weather_cloud) {
                    }.lparams(width = dip(30), height = dip(30))
                    imageButton(R.drawable.ic_weather_sun) {
                    }.lparams(width = dip(30), height = dip(30))
                    imageButton(R.drawable.ic_weather_rainbow) {
                    }.lparams(width = dip(30), height = dip(30))
                }.lparams(width = wrapContent, height = wrapContent){
                    topMargin = dip(20)
                }

                linearLayout {
                    gravity = Gravity.LEFT
                    imageView(R.drawable.ic_camera) {

                    }.lparams(width = dip(60), height = dip(60)) {
                        leftMargin = dip(20)
                        topMargin = dip(20)
                    }
                }

                editText {
                    gravity = Gravity.LEFT
                    backgroundResource = R.drawable.diary_space
                    hint = "당신만이 누리고 있는 행복을 붙잡아 기록해보세요."
                    maxLines = dip(6)
                    hintTextColor = Color.parseColor("#999999")
                    setLineSpacing(resources.getDimension(R.dimen.splash_content_text_size), 1.0f)
                    setTextSize(
                        TypedValue.COMPLEX_UNIT_PX,
                        resources.getDimension(R.dimen.diary_text_size)
                    )
                    textColor = Color.parseColor("#000000")
                    setTextCursorDrawable(R.drawable.cursor_color)
                }.lparams(width = dip(280), height = dip(160))


                    editText {
                        gravity = Gravity.LEFT
                        hint = "#태그입력"
                    }.lparams(width= matchParent, height=dip(32))

                    linearLayout{
                        switch(
                            
                        ).setOnClickListener{
                            toast("Toast Message")
                        }
                    }.lparams(width=dip(60), height=dip(32))

                    view { backgroundColor = android.R.color.transparent }.lparams(
                        width = dip(1),
                        height = wrapContent,
                        weight = 1f
                    )
                    linearLayout {
                        backgroundResource = R.drawable.bg_upload_btn
                        gravity = Gravity.CENTER

                        textView("행복 업로드") {

                            typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_bold)
                            setTextSize(
                                TypedValue.COMPLEX_UNIT_PX,
                                resources.getDimension(R.dimen.splash_start_text_size)
                            )
                            textColor = Color.parseColor("#FFFFFF")
                            gravity = Gravity.CENTER
                        }
                    }.lparams(width = matchParent, height = wrapContent) {
                        bottomMargin = dip(20)
                        horizontalMargin = dip(20)
                    }
            }.lparams(width= matchParent, height= wrapContent){
                horizontalMargin = dip(40)
                bottomMargin = dip(40)
            }
        }
    }
}