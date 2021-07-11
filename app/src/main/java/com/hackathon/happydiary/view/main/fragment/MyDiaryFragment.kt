package com.hackathon.happydiary.view.main.fragment

import android.content.Context
import android.os.Bundle
import android.widget.RelativeLayout
import com.hackathon.happydiary.adapter.main.my.MyDiaryListAdapter
import com.hackathon.happydiary.base.BaseFragment
import com.hackathon.happydiary.model.UserHappyInfo
import com.hackathon.happydiary.presenter.main.my.MyDiaryConstract
import com.hackathon.happydiary.presenter.main.my.MyDiaryPresenter
import com.hackathon.happydiary.utils.CommonUtil
import com.hackathon.happydiary.utils.DLog
import com.hackathon.happydiary.utils.DeviceUtils
import com.hackathon.happydiary.view.main.fragment.ui.MyDiaryUI
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.centerVertically
import org.jetbrains.anko.dip
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.ext.android.get

class MyDiaryFragment: BaseFragment<MyDiaryConstract.View, MyDiaryPresenter>(), MyDiaryConstract.View {

    companion object {
        var fragment: MyDiaryFragment? = null
        fun getInstance(): MyDiaryFragment
            = fragment ?: MyDiaryFragment().also { fragment = it }
    }

    lateinit var mAdapter: MyDiaryListAdapter

    override var layout: AnkoComponent<Context> = MyDiaryUI()
    override fun onCreatePresenter(): MyDiaryPresenter = get()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(layout as MyDiaryUI) {

            rv.adapter = MyDiaryListAdapter(ctx).also { mAdapter = it }

            presenter?.run {
                adapterView = mAdapter
                adapterModel = mAdapter

                requestMyDiary()
            }
        }
    }

    override fun bindHeader(info: UserHappyInfo) {
        with(layout as MyDiaryUI) {

            val deviceSize = DeviceUtils.getDeviceSize(ctx)
            val leftMargin = ((ctx.dip(360) * ctx.dip(20)) / deviceSize.x)
            val progressWidth = (deviceSize.x - (leftMargin * 2))
            var writeCntLeftMargin = ctx.dip(42)

            if (info.userWriteCount > 0) {
                val enableAreaWidth = ((progressWidth / info.levelupCount) * info.userWriteCount )
                writeCntLeftMargin = (leftMargin + ((enableAreaWidth / 2) - ctx.dip(19 / 2)))
            }

            myHappyCntTv.text = "Lv.${info.level}"
            with(myGaugePb) {
                progress = info.userWriteCount
                max = info.levelupCount
            }
            with(userWriteCntTv) {
                text = "${info.userWriteCount}건"
                layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT).apply {
                    this.leftMargin = writeCntLeftMargin
                    centerVertically()
                }
            }
            levelUpCntTv.text = "${info.levelupCount}건"
        }
    }
}