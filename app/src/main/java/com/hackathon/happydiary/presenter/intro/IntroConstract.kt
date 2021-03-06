package com.hackathon.happydiary.presenter.intro

import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView
import com.hackathon.happydiary.model.LogInData
import com.hackathon.happydiary.model.Response

interface IntroConstract {

    interface View: BaseView {
        fun initAppIcon()
        fun moveSplashPage(time: Long)
        fun moveMainPage(time: Long)
    }

    interface Presenter: BasePresenter<View> {
        fun validToken(callback: (Int, Response<LogInData>) -> Unit)
    }

}