package com.hackathon.happydiary.adapter.main.my

import com.hackathon.happydiary.base.BaseAdapterView

interface MyDiaryAdapterConstract {

    interface View: BaseAdapterView

    interface Model {
        fun initData(list: ArrayList<String>)
        fun addAllData(list: ArrayList<String>)
        fun clear()
    }

}