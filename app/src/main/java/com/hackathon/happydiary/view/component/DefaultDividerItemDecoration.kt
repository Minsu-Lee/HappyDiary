package com.hackathon.happydiary.view.component

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class DefaultDividerItemDecoration: DividerItemDecoration {

    companion object {
        const val TOP = "top"
        const val BOTTOM = "bottom"
        const val LEFT = "left"
        const val RIGHT = "right"
    }

    var mDivider: Drawable? = null
    var hashMap: HashMap<String, Int> = hashMapOf()

    constructor(ctx: Context, orientation: Int = DividerItemDecoration.VERTICAL, hashMap: HashMap<String, Int> = hashMapOf()): super(ctx, orientation) {
        this.hashMap = hashMap
    }
    constructor(ctx: Context, orientation: Int = DividerItemDecoration.VERTICAL, @DrawableRes drawRes: Int): super(ctx, orientation) {
        ContextCompat.getDrawable(ctx, drawRes)?.let { drawable -> mDivider = drawable }
    }
    constructor(ctx: Context, orientation: Int = DividerItemDecoration.VERTICAL, hashMap: HashMap<String, Int> = hashMapOf(), @DrawableRes drawRes: Int): super(ctx, orientation) {
        ContextCompat.getDrawable(ctx, drawRes)?.let { drawable -> mDivider = drawable }
        this.hashMap = hashMap
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        // super.getItemOffsets(outRect, view, parent, state)
        hashMap[TOP]?.let { top -> outRect.top = top}
        hashMap[BOTTOM]?.let { bottom -> outRect.bottom = bottom }
        hashMap[LEFT]?.let { left -> outRect.left = left }
        hashMap[RIGHT]?.let { right -> outRect.right = right }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        // super.onDraw(c, parent, state)
        val left = parent.paddingLeft + (hashMap[LEFT] ?: 0)
        val right = parent.width - (hashMap[RIGHT] ?: 0)

        // guide, empty 문구 노출 시, itemSize가 1개인 상태, divider를 그릴필요가 없음.
        var itemSize = parent.adapter?.itemCount ?: 0
        parent.children.forEach { child ->
            (child.layoutParams as RecyclerView.LayoutParams).let { params ->

                if (itemSize > 1) mDivider?.let { target ->
                    val top = child.bottom + params.bottomMargin
                    val bottom = top + target.intrinsicHeight

                    target.setBounds(left, top, right, bottom)
                    target.draw(c)
                }
            }
        }
    }

}