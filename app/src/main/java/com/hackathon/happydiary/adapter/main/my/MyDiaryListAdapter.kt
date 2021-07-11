package com.hackathon.happydiary.adapter.main.my

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.happydiary.adapter.main.my.holder.DiaryItemViewHolder
import com.hackathon.happydiary.adapter.main.my.holder.MainItemViewHolder
import com.hackathon.happydiary.adapter.main.my.ui.DiaryItemUI
import com.hackathon.happydiary.adapter.main.my.ui.MainItemUI
import com.hackathon.happydiary.base.BaseRecyclerAdapter
import com.hackathon.happydiary.model.DiaryData

class MyDiaryListAdapter(override val ctx: Context, override var list: ArrayList<DiaryData> = arrayListOf()): BaseRecyclerAdapter<DiaryData, RecyclerView.ViewHolder>(),
    MyDiaryAdapterConstract.View, MyDiaryAdapterConstract.Model {

    override fun useHeader(): Boolean = true

    override fun onCreateHeaderViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        return MainItemViewHolder(parent, MainItemUI())
    }

    override fun onBindHeaderItemView(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemViewHolder).onBind(position)
    }

    override fun onCreateBasicViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
        = DiaryItemViewHolder(parent, DiaryItemUI())

    override fun onBindBasicItemView(holderItem: RecyclerView.ViewHolder?, position: Int)
        = (holderItem as DiaryItemViewHolder).onBind(list, position)

    override fun initData(list: ArrayList<DiaryData>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun addAllData(list: ArrayList<DiaryData>) {
        this.list.addAll(list)
    }

    override fun clear() = list.clear()

    override fun notifyAdapter() = notifyDataSetChanged()

}