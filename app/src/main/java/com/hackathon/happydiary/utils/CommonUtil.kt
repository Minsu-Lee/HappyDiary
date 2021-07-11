package com.hackathon.happydiary.utils

import android.content.Context
import android.util.TypedValue

object CommonUtil {

    fun dpToPx(ctx: Context, dp: Float): Float
        = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ctx.resources.displayMetrics)

    fun pxToDp(ctx: Context, px: Float): Float {
        var density = ctx.resources.displayMetrics.density.toDouble()
        when (density) {
            // mdpi ( 160dpi )
            1.0 -> { density *= 4.0 }

            // hdpi ( 240dpi )
            1.5 -> { density *= (8 / 3) }

            // xhdpi ( 320dpi )
            else -> { density *= 2.0 }
        }
        return (px / density).toFloat()
    }

    /**
     * 이미지 높이 계산
     * deviceWidth: imgHeight = width : height
     */
    fun calcImgHeight(ctx: Context, width: Int, height: Int): Int {
        val deviceWidth = DeviceUtils.getDeviceSize(ctx).x
        return deviceWidth * height / width
    }
}