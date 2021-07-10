package com.hackathon.happydiary.presenter.main

import com.hackathon.happydiary.base.AbstractPresenter
import com.hackathon.happydiary.view.component.adapter.SampleAdapterConstract

class MainPresenter: AbstractPresenter<MainConstract.View>(), MainConstract.Presenter {

    override var adapterView: SampleAdapterConstract.View? = null
    override var adapterModel: SampleAdapterConstract.Model? = null

    override fun requestSampleList() {
        arrayListOf<String>().apply {
            (0 until 10).forEach {
                add(it.toString())
            }
        }.let { list ->
            view?.onBinding(list)
            adapterModel?.initData(list)
            adapterView?.notifyAdapter()
        }
    }
}