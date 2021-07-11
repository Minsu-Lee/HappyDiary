package com.hackathon.happydiary.presenter.main.my

import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.base.AbstractPresenter
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
            .subscribe({
                when (it.status) {
                    StatusConst.SUCCESS, StatusConst.SUCCESS201 -> {

                    }
                    else -> log("validToken", it.message)
                }
            }, this::handleError)
    }

}