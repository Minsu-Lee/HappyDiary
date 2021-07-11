package com.hackathon.happydiary.presenter.main.we

import com.hackathon.happydiary.base.AbstractPresenter
import com.hackathon.happydiary.network.DiaryAPIService

class WeDiaryPresenter(val diaryApi: DiaryAPIService): AbstractPresenter<WeDiaryConstract.View>(),
    WeDiaryConstract.Presenter {

    override var adapterView: WeDiaryAdapterConstract.View? = null
    override var adapterModel: WeDiaryAdapterConstract.Model? = null

}