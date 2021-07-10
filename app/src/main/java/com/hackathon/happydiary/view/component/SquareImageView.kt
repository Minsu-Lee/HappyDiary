package com.hackathon.happydiary.view.component

import android.content.Context
import android.util.AttributeSet

/**
 * ImageView의 width만큼 height을 할당하는 View
 */
class SquareImageView: androidx.appcompat.widget.AppCompatImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // widthMeasureSpec로 height 지정
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}