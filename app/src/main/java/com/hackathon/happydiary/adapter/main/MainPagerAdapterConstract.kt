package com.hackathon.happydiary.adapter.main

import androidx.fragment.app.Fragment
import com.hackathon.happydiary.base.BaseAdapterView

interface MainPagerAdapterConstract {

    interface View: BaseAdapterView

    interface Model {
        fun initData(list: ArrayList<Fragment>)
        fun addAllData(list: ArrayList<Fragment>)
        fun clear()
    }

}