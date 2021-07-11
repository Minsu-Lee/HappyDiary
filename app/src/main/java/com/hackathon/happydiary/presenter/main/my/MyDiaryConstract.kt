package com.hackathon.happydiary.presenter.main.my

import com.hackathon.happydiary.adapter.main.my.MyDiaryAdapterConstract
import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView
import com.hackathon.happydiary.model.UserHappyInfo

interface MyDiaryConstract {

    interface View: BaseView {
        fun bindHeader(info: UserHappyInfo)
    }

    interface Presenter: BasePresenter<View> {
        var adapterView: MyDiaryAdapterConstract.View?
        var adapterModel: MyDiaryAdapterConstract.Model?
        fun requestMyDiary()
    }

}