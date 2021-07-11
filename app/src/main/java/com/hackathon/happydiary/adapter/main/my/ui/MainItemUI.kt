package com.hackathon.happydiary.adapter.main.my.ui

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import com.hackathon.happydiary.utils.DeviceUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.guideline

class MainItemUI: AnkoComponent<ViewGroup> {

    lateinit var myHappyCntTv: TextView
    lateinit var userWriteCntTv: TextView
    lateinit var levelUpCntTv: TextView
    lateinit var myGaugePb: ProgressBar

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= dip(552)) {
                backgroundColor = Color.TRANSPARENT

                view{ backgroundColor = Color.TRANSPARENT }.lparams(width= dip(1), height= wrapContent, weight= 1f)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL

                        textView("나의 행복지수") {

                            typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_bold)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_tab_happy_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.my_tab_happy_text_line_height), 1.0f)
                            gravity = Gravity.TOP

                        }.lparams(width= wrapContent, height= matchParent) {
                            rightMargin = dip(4)
                        }

                        myHappyCntTv = textView("Lv.1") {

                            typeface = ResourcesCompat.getFont(context, R.font.nunito_extra_bold)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_tab_happy_level_text_size))
                            textColor = Color.parseColor("#6B53FF")
                            setLineSpacing(resources.getDimension(R.dimen.my_tab_happy_level_text_line_height), 1.0f)
                            gravity = Gravity.TOP

                        }.lparams(width= wrapContent, height= matchParent)

                    }.lparams(width= wrapContent, height= matchParent)

                    view{ backgroundColor = Color.TRANSPARENT }.lparams(width= wrapContent, height= dip(1), weight= 1f)

                    imageView(R.drawable.ic_my_happy_flag) {
                    }.lparams(width= dip(12), height= dip(23)) {
                        rightMargin = dip(10)
                    }

                }.lparams(width= matchParent, height= dip(24)) {
                    horizontalMargin = dip(20)
                }

                relativeLayout {

                    myGaugePb = horizontalProgressBar {
                        progressDrawable = ContextCompat.getDrawable(context, R.drawable.custom_main_progressbar)
                        progress = 2
                        max = 10
                    }.lparams(width= matchParent, height= dip(24)) {
                        horizontalMargin = dip(20)
                    }

                    userWriteCntTv = textView("2건") {

                        typeface = ResourcesCompat.getFont(context, R.font.nunito_bold)
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_write_cnt_text_size))
                        textColor = Color.parseColor("#FFFFFF")
                        setLineSpacing(resources.getDimension(R.dimen.my_write_cnt_text_line_height), 1.0f)
                        gravity = Gravity.TOP

                    }.lparams(width= wrapContent, height= wrapContent) {
                        centerVertically()
                        leftMargin = dip(42)
                    }

                    levelUpCntTv = textView("10건") {

                        typeface = ResourcesCompat.getFont(context, R.font.nunito_extra_bold)
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_levelup_cnt_text_size))
                        textColor = Color.parseColor("#6B53FF")
                        setLineSpacing(resources.getDimension(R.dimen.my_levelup_cnt_text_line_height), 1.0f)
                        gravity = Gravity.TOP

                    }.lparams(width= wrapContent, height= wrapContent) {
                        centerVertically()
                        alignParentRight()
                        rightMargin = dip(30)
                    }

                }.lparams(width= matchParent, height= dip(24)) {
                    bottomMargin = dip(40)
                }

                verticalLayout {

                    backgroundResource = R.drawable.bg_radius20_ff
                    gravity = Gravity.CENTER_HORIZONTAL

                    textView("나의 행복기록") {

                        typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_bold)
                        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_happy_history_text_size))
                        textColor = Color.parseColor("#1A1A1A")
                        setLineSpacing(resources.getDimension(R.dimen.my_happy_history_text_line_height), 1.0f)
                        gravity = Gravity.TOP

                    }.lparams(width= wrapContent, height= wrapContent) {
                        topMargin = dip(40)
                        bottomMargin = dip(10)
                    }

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER

                        textView("2021.07") {

                            typeface = ResourcesCompat.getFont(context, R.font.nunito_bold)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.my_happy_history_date_text_size))
                            textColor = Color.parseColor("#999999")
                            setLineSpacing(resources.getDimension(R.dimen.my_happy_history_date_text_line_height), 1.0f)
                            gravity = Gravity.CENTER

                        }.lparams(width= wrapContent, height= wrapContent)

                        squareImageView(R.drawable.ic_allow_down_img) {
                        }.lparams(width= dip(16))

                    }.lparams(width= wrapContent, height= wrapContent)

                }.lparams(width= matchParent, height= dip(102))
            }
        }
    }
}