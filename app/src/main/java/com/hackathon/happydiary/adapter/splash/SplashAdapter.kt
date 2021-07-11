package com.hackathon.happydiary.adapter.splash

import android.content.Context
import android.graphics.Point
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.happydiary.adapter.splash.holder.SplashEndViewHolder
import com.hackathon.happydiary.adapter.splash.holder.SplashStartViewHolder
import com.hackathon.happydiary.adapter.splash.holder.SplashViewHolder
import com.hackathon.happydiary.adapter.splash.ui.SplashEndImageUI
import com.hackathon.happydiary.adapter.splash.ui.SplashImageUI
import com.hackathon.happydiary.adapter.splash.ui.SplashStartImageUI
import com.hackathon.happydiary.base.BaseRecyclerAdapter
import com.hackathon.happydiary.utils.DeviceUtils

class SplashAdapter(override val ctx: Context, override var list: ArrayList<Int> = arrayListOf()): BaseRecyclerAdapter<Int, RecyclerView.ViewHolder>() ,
    SplashAdapterConstract.View, SplashAdapterConstract.Model{

    private var deviceSize: Point = DeviceUtils.getDeviceSize(ctx)

    override fun onCreateBasicViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
        = when (viewType) {
            0 -> SplashStartViewHolder(parent, SplashStartImageUI(deviceSize))
            1 -> SplashViewHolder(parent, SplashImageUI(deviceSize))
            else -> SplashEndViewHolder(parent, SplashEndImageUI(deviceSize))
        }

    override fun onBindBasicItemView(holder: RecyclerView.ViewHolder?, position: Int) {
        when(position) {
            0 -> (holder as? SplashStartViewHolder)?.onBind(position)
            1 -> (holder as? SplashViewHolder)?.onBind(position)
            else -> (holder as? SplashEndViewHolder)?.onBind(position)
        }
    }

    override fun initData(list: ArrayList<Int>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun addAllData(list: ArrayList<Int>) {
        this.list.addAll(list)
    }

    override fun clear() = list.clear()

    override fun notifyAdapter() = notifyDataSetChanged()

}