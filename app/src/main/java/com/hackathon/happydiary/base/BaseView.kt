package com.hackathon.happydiary.base

import java.util.concurrent.TimeUnit

interface BaseView {

    fun onBinding(data: Any? = null) { }

    fun onVisibleProgress() { }

    fun onInvisibleProgress() { }

    fun movePage(callback: (Long)->Unit, delay: Long = 2000L, timeUnit: TimeUnit = TimeUnit.MILLISECONDS)

}