package com.hackathon.happydiary.presenter.main.my

import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView

interface MyDiaryAdapterConstract {

    interface View: BaseView {

    }

    interface Model: BasePresenter<View> {

    }

}