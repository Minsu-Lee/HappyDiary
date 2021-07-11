package com.hackathon.happydiary.adapter.main.my

import com.hackathon.happydiary.base.BaseAdapterView
import com.hackathon.happydiary.model.DiaryData

interface MyDiaryAdapterConstract {

    interface View: BaseAdapterView

    interface Model {
        fun initData(list: ArrayList<DiaryData>)
        fun addAllData(list: ArrayList<DiaryData>)
        fun clear()
    }

}