package com.hackathon.happydiary.view.main.fragment

import android.content.Context
import android.os.Bundle
import com.hackathon.happydiary.adapter.main.my.MyDiaryListAdapter
import com.hackathon.happydiary.base.BaseFragment
import com.hackathon.happydiary.presenter.main.my.MyDiaryConstract
import com.hackathon.happydiary.presenter.main.my.MyDiaryPresenter
import com.hackathon.happydiary.view.main.fragment.ui.MyDiaryUI
import org.jetbrains.anko.AnkoComponent
import org.koin.android.ext.android.get

class MyDiaryFragment: BaseFragment<MyDiaryConstract.View, MyDiaryPresenter>(), MyDiaryConstract.View {

    companion object {
        fun getInstance(): MyDiaryFragment {
//            val args = Bundle().apply {
//                putString("", "")
//            }
            return MyDiaryFragment().apply {
                //arguments = args
            }
        }
    }

    lateinit var mAdapter: MyDiaryListAdapter

    override var layout: AnkoComponent<Context> = MyDiaryUI()
    override fun onCreatePresenter(): MyDiaryPresenter = get()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(layout as MyDiaryUI) {

            with(rv) {
                adapter = MyDiaryListAdapter(context)
                    .also { mAdapter = it }
            }

            presenter?.run {
                adapterView = mAdapter
                adapterModel = mAdapter

                requestMyDiary()
            }
        }
    }
}