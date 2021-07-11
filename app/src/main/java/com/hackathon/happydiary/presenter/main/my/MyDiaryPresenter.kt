package com.hackathon.happydiary.presenter.main.my

import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.adapter.main.my.MyDiaryAdapterConstract
import com.hackathon.happydiary.base.AbstractPresenter
import com.hackathon.happydiary.model.UserHappyInfo
import com.hackathon.happydiary.network.DiaryAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyDiaryPresenter(val diaryApi: DiaryAPIService): AbstractPresenter<MyDiaryConstract.View>(),
    MyDiaryConstract.Presenter {

    override var adapterView: MyDiaryAdapterConstract.View? = null
    override var adapterModel: MyDiaryAdapterConstract.Model? = null

    override fun requestMyDiary() {
        diaryApi.requestMyDiary()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->

                when (response.status) {
                    StatusConst.SUCCESS, StatusConst.SUCCESS201 -> {
                        response.data?.let {
                            adapterModel?.setHeaderData(it.user)
                            adapterModel?.initData(it.diary)
                            adapterView?.notifyAdapter()
                        }
                    }
                    else -> {
                        log("validToken", response.message)
                        adapterModel?.setHeaderData(UserHappyInfo(1, 10, 0))
                        adapterView?.notifyAdapter()
                    }
                }
            }, {
                handleError(it)
                log("validToken", it.message ?: "")
                adapterModel?.setHeaderData(UserHappyInfo(1, 10, 0))
                adapterView?.notifyAdapter()
            })
    }

}