package com.hackathon.happydiary.adapter.sample

import android.content.Context
import android.view.ViewGroup
import com.hackathon.happydiary.adapter.sample.holder.SampleViewHolder
import com.hackathon.happydiary.adapter.sample.ui.SampleUI
import com.hackathon.happydiary.base.BaseRecyclerAdapter

class SampleListAdapter(override val ctx: Context, override var list: ArrayList<String> = arrayListOf()): BaseRecyclerAdapter<String, SampleViewHolder>(),
    SampleAdapterConstract.View, SampleAdapterConstract.Model {

    override fun onCreateBasicViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder
        = SampleViewHolder(parent, SampleUI())

    override fun onBindBasicItemView(holder: SampleViewHolder?, position: Int) {
        holder?.onBind(position)
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