package com.hackathon.happydiary.adapter.main.my.ui

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.guideline

class MainItemUI: AnkoComponent<ViewGroup> {

    lateinit var pbMyGauge: ProgressBar

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= dip(450)) {
                // backgroundColor = Color.TRANSPARENT
                backgroundResource = R.drawable.bg_main_img

                guideline().lparams(width= dip(1), height= wrapContent, weight= 1f)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        bottomPadding = dip(10)

                        textView("나의 행복지수") {

                            typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_bold)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_tab_happy_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.my_tab_happy_text_line_height), 1.0f)
                            gravity = Gravity.CENTER

                        }.lparams(width= wrapContent, height= matchParent) {
                            rightMargin = dip(4)
                            bottomMargin = dip(10)
                        }

                        textView("Lv.1") {

                            typeface = ResourcesCompat.getFont(context, R.font.nunito_extra_bold)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_tab_happy_level_text_size))
                            textColor = Color.parseColor("#6B53FF")
                            setLineSpacing(resources.getDimension(R.dimen.my_tab_happy_level_text_line_height), 1.0f)
                            gravity = Gravity.CENTER

                        }.lparams(width= wrapContent, height= matchParent)

                    }.lparams(width= wrapContent, height= matchParent)

                    guideline().lparams(width= wrapContent, height= dip(1), weight= 1f)

                    imageView(R.drawable.ic_my_happy_flag) {
                    }.lparams(width= dip(12), height= dip(23)) {
                        rightMargin = dip(10)
                    }

                }.lparams(width= matchParent, height= dip(14)) {
                    horizontalMargin = dip(20)
                }

                verticalLayout {

                    pbMyGauge = progressBar {
                        progressDrawable = ContextCompat.getDrawable(context, R.drawable.custom_main_progressbar)
                    }.lparams(width= matchParent, height= dip(24)) {
                        horizontalMargin = dip(20)
                    }
                }.lparams(width= matchParent, height= wrapContent) {
                    bottomMargin = dip(40)
                }
            }
        }
    }
}