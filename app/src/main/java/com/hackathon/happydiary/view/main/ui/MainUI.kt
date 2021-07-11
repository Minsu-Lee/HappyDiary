package com.hackathon.happydiary.view.main.ui

import android.app.Activity
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager.widget.ViewPager
import com.hackathon.happydiary.R
import com.hackathon.happydiary.extensions.squareImageView
import com.hackathon.happydiary.view.component.SquareImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.viewPager

class MainUI: AnkoComponent<Activity> {

    lateinit var vp: ViewPager
    lateinit var writeBtn: LinearLayout

    var tabs: ArrayList<LinearLayout> = arrayListOf()
    var tabIvs: ArrayList<SquareImageView> = arrayListOf()

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent) {
                backgroundColor = Color.TRANSPARENT

                vp = viewPager {
                    id = R.id.main_viewpager
                    // orientation = ViewPager2.ORIENTATION_HORIZONTAL
                }.lparams(width= matchParent, height= wrapContent, weight= 1f)

                linearLayout {
                    backgroundColor = Color.WHITE

                    verticalLayout {
                        id = R.id.my_diary_list
                        tabs.add(this)
                        gravity = Gravity.CENTER

                        squareImageView {
                            scaleType = ImageView.ScaleType.FIT_XY
                            backgroundResource = R.drawable.ic_me_img_on
                            tabIvs.add(this)
                        }.lparams(width= dip(32))

                        textView(R.string.tab_me_str) {

                            typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_medium)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.main_tab_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.main_tab_text_line_height), 1.0f)
                            gravity = Gravity.CENTER_VERTICAL

                        }.lparams(width= wrapContent, height= wrapContent)

                    }.lparams(width= 0, height= matchParent, weight= 1f)

                    /**
                     * 행복찾기, 글작성
                     */
                    writeBtn = verticalLayout {
                        id = R.id.diary_write
                        gravity = Gravity.CENTER

                        squareImageView(R.drawable.ic_write_img) {
                            scaleType = ImageView.ScaleType.FIT_XY
                        }.lparams(width= dip(32))

                        textView(R.string.tab_write_str) {

                            typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_medium)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.main_tab_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.main_tab_text_line_height), 1.0f)
                            gravity = Gravity.CENTER_VERTICAL

                        }.lparams(width= wrapContent, height= wrapContent)

                    }.lparams(width= 0, height= matchParent, weight= 1f)

                    verticalLayout {
                        id = R.id.other_diary_list
                        tabs.add(this)
                        gravity = Gravity.CENTER

                        squareImageView {
                            scaleType = ImageView.ScaleType.FIT_XY
                            backgroundResource = R.drawable.ic_we_img_on
                            tabIvs.add(this)
                        }.lparams(width= dip(32))

                        textView(R.string.tab_we_str) {

                            typeface = ResourcesCompat.getFont(context, R.font.notosans_cjk_medium)
                            setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.main_tab_text_size))
                            textColor = Color.parseColor("#1A1A1A")
                            setLineSpacing(resources.getDimension(R.dimen.main_tab_text_line_height), 1.0f)
                            gravity = Gravity.CENTER_VERTICAL

                        }.lparams(width= wrapContent, height= wrapContent)

                    }.lparams(width= 0, height= matchParent, weight= 1f)

                }.lparams(width= matchParent, height= dip(62))

            }
        }
    }
}