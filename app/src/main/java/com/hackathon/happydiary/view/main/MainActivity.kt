package com.hackathon.happydiary.view.main

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.happydiary.presenter.main.MainPresenter
import com.hackathon.happydiary.base.BaseActivity
import com.hackathon.happydiary.presenter.main.MainConstract
import com.hackathon.happydiary.view.component.adapter.SampleListAdapter
import com.hackathon.happydiary.view.main.ui.MainUI
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.toast
import org.koin.android.ext.android.get

class MainActivity: BaseActivity<MainConstract.View, MainPresenter>(), MainConstract.View {

    lateinit var mAdapter: SampleListAdapter

    override var layout: AnkoComponent<Activity> = MainUI()
    override fun onCreatePresenter(): MainPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(layout as MainUI) {

            with(rv) {
                addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL))
                adapter = SampleListAdapter(this@MainActivity).apply {
                    setOnItemClickListener(this@MainActivity::onItemClick)
                }.also { mAdapter = it }
            }

            presenter?.run {
                adapterView = mAdapter
                adapterModel = mAdapter
                requestSampleList()
            }
        }
    }

    override fun onBinding(data: Any?) { toast("init list data") }

    override fun onItemClick(view: View, id: Int, position: Int) {
        toast("itemClick, position: $position")
    }

}