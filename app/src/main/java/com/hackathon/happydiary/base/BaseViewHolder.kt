package com.hackathon.happydiary.base

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

abstract class BaseViewHolder(
    parent: ViewGroup,
    ui: AnkoComponent<ViewGroup>,
    positionCallback: ((viewId: Int, position: Int) -> Unit)? = null): RecyclerView.ViewHolder(ui.createView(AnkoContext.create(parent.context, parent))) {

    val ctx: Context = itemView.context
    var positionCallback: (viewId: Int, position: Int) -> Unit = { _,_ -> }

    init {
        positionCallback?.let { this.positionCallback = it }
    }
}