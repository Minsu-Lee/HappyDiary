package com.hackathon.happydiary.presenter.intro

import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.base.AbstractPresenter
import com.hackathon.happydiary.model.Response
import com.hackathon.happydiary.network.UserAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class IntroPresenter(val userApi: UserAPIService): AbstractPresenter<IntroConstract.View>(), IntroConstract.Presenter {

    override fun validToken(token: String, callback: (Int, Response<String>) -> Unit) {
        userApi.validToken(token)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it.status) {
                    StatusConst.SUCCESS -> callback(it.status, it)
                    StatusConst.SUCCESS201 -> {
                        callback(it.status, it)
                        log("validToken", "토큰 갱신")
                    }
                    StatusConst.NEW_USER -> callback(it.status, it)
                    else -> log("validToken", it.message)
                }
            }, this::handleError)
    }
}