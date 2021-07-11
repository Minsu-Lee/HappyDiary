package com.hackathon.happydiary.view.main.fragment.ui

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.happydiary.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MyDiaryUI: AnkoComponent<Context> {

    lateinit var myHappyCntTv: TextView
    lateinit var userWriteCntTv: TextView
    lateinit var levelUpCntTv: TextView
    lateinit var myGaugePb: ProgressBar
    lateinit var rv: RecyclerView

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        relativeLayout {
            lparams(width= matchParent, height= matchParent)
            backgroundResource = R.drawable.bg_main_img



            verticalLayout {
                backgroundColor = Color.TRANSPARENT

                view{ backgroundColor = Color.TRANSPARENT }.lparams(width= dip(1), height= wrapContent, weight= 1f)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL

                        textView("나의 행복지수") {

                            typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_extra_bold)
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
                        topMargin = dip(2)
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
                        textColor = Color.WHITE
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

            }.lparams(width= matchParent, height= dip(450))




            rv = recyclerView {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }.lparams(width= matchParent, height= matchParent)
        }
    }
}