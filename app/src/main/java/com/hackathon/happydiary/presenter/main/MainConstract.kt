package com.hackathon.happydiary.presenter.main

import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView
import com.hackathon.happydiary.view.component.adapter.SampleAdapterConstract

interface MainConstract {

    interface View: BaseView {
        fun onItemClick(view: android.view.View, id: Int, position: Int)
    }

    interface Presenter: BasePresenter<View> {
        fun requestSampleList()
        var adapterView: SampleAdapterConstract.View?
        var adapterModel: SampleAdapterConstract.Model?
    }

}