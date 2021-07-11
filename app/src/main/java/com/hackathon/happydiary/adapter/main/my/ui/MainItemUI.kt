package com.hackathon.happydiary.adapter.main.my.ui

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import org.jetbrains.anko.*

class MainItemUI: AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= dip(552)) {
                backgroundColor = Color.TRANSPARENT





                view{ backgroundColor = Color.TRANSPARENT }.lparams(width= dip(1), height= wrapContent, weight= 1f)





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