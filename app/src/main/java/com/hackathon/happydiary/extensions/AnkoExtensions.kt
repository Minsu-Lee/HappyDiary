package com.hackathon.happydiary.extensions

import android.view.View
import android.view.ViewManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.hackathon.happydiary.view.component.SquareImageView
import org.jetbrains.anko.custom.ankoView

fun View.string(res: Int): String = context.resources.getString(res)
fun View.integer(res: Int): Int = context.resources.getInteger(res)
fun View.deviceWidth(): Int = resources.displayMetrics.widthPixels

/** width와 height이 같은 Layout 추가 */
inline fun ViewManager.squareImageView() = squareImageView {}
inline fun ViewManager.squareImageView(init: SquareImageView.() -> Unit): SquareImageView {
    return ankoView({ SquareImageView(it) }, theme= 0, init= init)
}
inline fun ViewManager.squareImageView(imageResource: Int, init: SquareImageView.() -> Unit): SquareImageView {
    return ankoView({ SquareImageView(it) }, theme= 0) {
        init()
        setImageResource(imageResource)
    }
}

inline fun ViewManager.swipeRefreshLayout() = swipeRefreshLayout {}
inline fun ViewManager.swipeRefreshLayout(init: SwipeRefreshLayout.() -> Unit): SwipeRefreshLayout {
    return ankoView({ SwipeRefreshLayout(it) }, theme= 0, init= init)
}