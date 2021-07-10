package com.hackathon.happydiary.view.component.adapter

import com.hackathon.happydiary.base.BaseAdapterView

interface SampleAdapterConstract {

    interface View: BaseAdapterView

    interface Model {
        fun initData(list: ArrayList<String>)
        fun addAllData(list: ArrayList<String>)
        fun clear()
    }

}