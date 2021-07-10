package com.hackathon.happydiary.view.main.ui

import android.app.Activity
import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUI: AnkoComponent<Activity> {

    lateinit var rv: RecyclerView

    override fun createView(ui: AnkoContext<Activity>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= wrapContent) {
                backgroundColor = Color.TRANSPARENT

                rv = recyclerView {
                    layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    backgroundColor = Color.WHITE
                }.lparams(width= matchParent, height= matchParent)

            }
        }
    }
}