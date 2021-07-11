package com.hackathon.happydiary.presenter.main

import androidx.fragment.app.Fragment
import com.hackathon.happydiary.adapter.main.MainPagerAdapterConstract
import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView

interface MainConstract {

    interface View: BaseView {
        fun initTabPosition(position: Int = 0)
    }

    interface Presenter: BasePresenter<View> {
        fun initFragments(): ArrayList<Fragment>
        fun initFragmentMap(): HashMap<Int, Fragment>
        var adapterView: MainPagerAdapterConstract.View?
        var adapterModel: MainPagerAdapterConstract.Model?
    }

}