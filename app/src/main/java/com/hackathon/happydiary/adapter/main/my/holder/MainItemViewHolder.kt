package com.hackathon.happydiary.adapter.main.my.holder

import android.view.ViewGroup
import android.widget.RelativeLayout
import com.hackathon.happydiary.adapter.main.my.ui.MainItemUI
import com.hackathon.happydiary.base.BaseViewHolder
import com.hackathon.happydiary.model.DiaryData
import com.hackathon.happydiary.model.UserHappyInfo
import com.hackathon.happydiary.utils.DeviceUtils
import org.jetbrains.anko.dip
import org.jetbrains.anko.wrapContent

class MainItemViewHolder(parent: ViewGroup, val ui: MainItemUI): BaseViewHolder(parent, ui) {

    fun onBind(userHappyInfo: UserHappyInfo? = null, position: Int) = with(ui) {
        userHappyInfo?.let { info ->

            val deviceSize = DeviceUtils.getDeviceSize(ctx)
            val leftMargin = (deviceSize.x * ctx.dip(20)) - ctx.dip(360)
            val leftInnerMargin = (deviceSize.x * ctx.dip(22)) - ctx.dip(360)

            myHappyCntTv.text = "Lv.${info.level}"

            with(userWriteCntTv) {
                text = "${info.userWriteCount}건"
                layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT).apply {
                    this.leftMargin = (leftMargin + leftInnerMargin)
                }
            }

            levelUpCntTv.text = "${info.levelupCount}건"

        }
    }
}