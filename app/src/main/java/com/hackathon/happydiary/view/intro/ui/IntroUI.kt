package com.hackathon.happydiary.view.intro.ui

import android.app.Activity
import com.hackathon.happydiary.R
import org.jetbrains.anko.*

class IntroUI: AnkoComponent<Activity> {

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent)
            backgroundResource = R.drawable.bg_splash_unicorn
        }
    }
}