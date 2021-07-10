package com.hackathon.happydiary.base

interface BaseView {

    fun onBinding(data: Any? = null) { }

    fun onVisibleProgress() { }

    fun onInvisibleProgress() { }

}