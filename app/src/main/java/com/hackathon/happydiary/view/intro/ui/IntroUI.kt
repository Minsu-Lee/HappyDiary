package com.hackathon.happydiary.view.intro.ui

import android.app.Activity
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import com.hackathon.happydiary.view.component.SquareImageView
import org.jetbrains.anko.*

class IntroUI: AnkoComponent<Activity> {

    lateinit var mIntroIconIv: SquareImageView
    lateinit var mIntroTitleTv: TextView
    lateinit var mIntroDescTv: TextView

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= matchParent)
            backgroundColor = Color.parseColor("#6B53FF")
            leftPadding = dip(60)

            mIntroIconIv = squareImageView(R.drawable.ic_intro_img) {
            }.lparams(width= dip(100)) {
                topMargin = dip(140)
                bottomMargin = dip(32)
            }

            mIntroTitleTv = textView(R.string.app_name) {

                typeface = ResourcesCompat.getFont(context, R.font.nanum_myeongjo_extra_bold)
                setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.intro_title_text_size))
                textColor = Color.parseColor("#FFFFFF")
                setLineSpacing(resources.getDimension(R.dimen.intro_title_text_line_height), 1.0f)
                gravity = Gravity.CENTER

            }.lparams(width= wrapContent, height= wrapContent) {
                bottomMargin = dip(10)
            }

            mIntroDescTv = textView(R.string.app_intro_str) {

                typeface = ResourcesCompat.getFont(context, R.font.nunito_black)
                setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.intro_desc_text_size))
                textColor = Color.parseColor("#FFFFFF")
                setLineSpacing(resources.getDimension(R.dimen.intro_desc_text_line_height), 1.0f)
                gravity = Gravity.CENTER_VERTICAL

            }.lparams(width= wrapContent, height= wrapContent)

        }
    }
}