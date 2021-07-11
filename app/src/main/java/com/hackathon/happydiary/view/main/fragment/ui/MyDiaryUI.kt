package com.hackathon.happydiary.view.main.fragment.ui

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.happydiary.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MyDiaryUI: AnkoComponent<Context> {

    lateinit var rv: RecyclerView

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        verticalLayout {
            lparams(width= matchParent, height= matchParent)
            backgroundResource = R.drawable.bg_main_img

            rv = recyclerView {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }.lparams(width= matchParent, height= matchParent)
        }
    }
}