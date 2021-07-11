package com.hackathon.happydiary.view.main.fragment.ui

import android.content.Context
import android.graphics.Color
import org.jetbrains.anko.*

class WeDiaryUI: AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent) {
                backgroundColor = Color.TRANSPARENT
                backgroundColor = Color.BLUE

            }
        }
    }
}