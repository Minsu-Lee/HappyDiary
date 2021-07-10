package com.hackathon.happydiary.view.component.adapter.ui

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.hackathon.happydiary.R
import org.jetbrains.anko.*

class SampleUI: AnkoComponent<ViewGroup> {

    lateinit var sampleTv: TextView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent) {
                backgroundColor = Color.TRANSPARENT

                sampleTv = textView("test") {

                    setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sample_text_size))
                    textColor = Color.parseColor("#00AAFF")
                    typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_black)
                    gravity = Gravity.CENTER

                }.lparams(width= wrapContent, height= wrapContent)

            }
        }
    }
}