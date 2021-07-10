package com.hackathon.happydiary.utils

import android.content.Context

object CommonUtil {

    /**
     * 이미지 높이 계산
     * deviceWidth: imgHeight = width : height
     */
    private fun calcImgHeight(ctx: Context, width: Int, height: Int): Int {
        val deviceWidth = DeviceUtils.getDeviceSize(ctx).x
        return deviceWidth * height / width
    }
}