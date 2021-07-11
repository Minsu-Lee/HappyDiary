package com.hackathon.happydiary.adapter.main.my

import android.content.Context
import android.view.ViewGroup
import com.hackathon.happydiary.adapter.main.my.holder.MainItemViewHolder
import com.hackathon.happydiary.adapter.main.my.ui.MainItemUI
import com.hackathon.happydiary.base.BaseRecyclerAdapter

class MyDiaryListAdapter(override val ctx: Context, override var list: ArrayList<String> = arrayListOf()): BaseRecyclerAdapter<String, MainItemViewHolder>(),
    MyDiaryAdapterConstract.View, MyDiaryAdapterConstract.Model {

    override fun onCreateBasicViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder
        = MainItemViewHolder(parent, MainItemUI())

    override fun onBindBasicItemView(holderItem: MainItemViewHolder?, position: Int) {
        holderItem?.onBind(position)
    }

    override fun initData(list: ArrayList<String>) {
        this.list.clear()
        this.list.addAll(list)
    }
    override fun addAllData(list: ArrayList<String>) {
        this.list.addAll(list)
    }

    override fun clear() = list.clear()
    override fun notifyAdapter() = notifyDataSetChanged()

}