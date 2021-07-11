package com.hackathon.happydiary.view.main.fragment

import android.content.Context
import android.os.Bundle
import com.hackathon.happydiary.base.BaseFragment
import com.hackathon.happydiary.presenter.main.we.WeDiaryConstract
import com.hackathon.happydiary.presenter.main.we.WeDiaryPresenter
import com.hackathon.happydiary.view.main.fragment.ui.WeDiaryUI
import org.jetbrains.anko.AnkoComponent
import org.koin.android.ext.android.get

class WeDiaryFragment: BaseFragment<WeDiaryConstract.View, WeDiaryPresenter>(), WeDiaryConstract.View {

    companion object {
        fun getInstance(): WeDiaryFragment {
//            val args = Bundle().apply {
//                putString("", "")
//            }
            return WeDiaryFragment().apply {
                //arguments = args
            }
        }
    }

    override var layout: AnkoComponent<Context> = WeDiaryUI()
    override fun onCreatePresenter(): WeDiaryPresenter = get()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}