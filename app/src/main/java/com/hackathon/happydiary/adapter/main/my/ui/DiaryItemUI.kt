package com.hackathon.happydiary.adapter.main.my.ui

import android.graphics.Color
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.*

class DiaryItemUI: AnkoComponent<ViewGroup> {

    lateinit var fragment: Fragment

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent) {
                backgroundColor = Color.TRANSPARENT


            }
        }
    }
}