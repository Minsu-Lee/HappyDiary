package com.hackathon.happydiary.presenter.main.we

import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView

interface WeDiaryConstract {

    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {
        var adapterView: WeDiaryAdapterConstract.View?
        var adapterModel: WeDiaryAdapterConstract.Model?
    }

}