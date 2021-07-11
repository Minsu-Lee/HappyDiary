package com.hackathon.happydiary.presenter.main.we

import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView

interface WeDiaryAdapterConstract {

    interface View: BaseView {

    }

    interface Model: BasePresenter<View> {

    }

}