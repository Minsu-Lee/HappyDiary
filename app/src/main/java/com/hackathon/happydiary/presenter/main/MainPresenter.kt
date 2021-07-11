package com.hackathon.happydiary.presenter.main

import androidx.fragment.app.Fragment
import com.hackathon.happydiary.adapter.main.MainPagerAdapterConstract
import com.hackathon.happydiary.base.AbstractPresenter
import com.hackathon.happydiary.network.UserAPIService
import com.hackathon.happydiary.view.main.fragment.MyDiaryFragment
import com.hackathon.happydiary.view.main.fragment.WeDiaryFragment

class MainPresenter(val userApi: UserAPIService): AbstractPresenter<MainConstract.View>(), MainConstract.Presenter {

    override var adapterView: MainPagerAdapterConstract.View? = null
    override var adapterModel: MainPagerAdapterConstract.Model? = null

    override fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            MyDiaryFragment.getInstance() as Fragment,
            WeDiaryFragment.getInstance() as Fragment
        ).also {
            adapterModel?.initData(it)
            adapterView?.notifyAdapter()
        }
    }

    override fun initFragmentMap(): HashMap<Int, Fragment> = hashMapOf(
        0 to MyDiaryFragment.getInstance(),
        1 to WeDiaryFragment.getInstance()
    )
}