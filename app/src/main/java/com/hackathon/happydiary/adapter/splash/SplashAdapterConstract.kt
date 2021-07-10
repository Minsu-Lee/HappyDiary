package com.hackathon.happydiary.adapter.splash

import com.hackathon.happydiary.base.BaseAdapterView

interface SplashAdapterConstract {

    interface View: BaseAdapterView

    interface Model {
        fun initData(list: ArrayList<Int>)
        fun addAllData(list: ArrayList<Int>)
        fun clear()
    }

}