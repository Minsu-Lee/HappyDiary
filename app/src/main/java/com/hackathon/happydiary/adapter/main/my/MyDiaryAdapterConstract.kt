package com.hackathon.happydiary.adapter.main.my

import com.hackathon.happydiary.base.BaseAdapterView
import com.hackathon.happydiary.model.DiaryData
import com.hackathon.happydiary.model.UserHappyInfo

interface MyDiaryAdapterConstract {

    interface View: BaseAdapterView

    interface Model {
        fun initData(list: ArrayList<DiaryData>)
        fun addAllData(list: ArrayList<DiaryData>)
        fun clear()

        fun setHeaderData(user: UserHappyInfo)
    }

}