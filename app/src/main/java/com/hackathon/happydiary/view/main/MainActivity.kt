package com.hackathon.happydiary.view.main

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.hackathon.happydiary.R
import com.hackathon.happydiary.adapter.main.MainPagerAdapter
import com.hackathon.happydiary.base.BaseActivity
import com.hackathon.happydiary.presenter.main.MainConstract
import com.hackathon.happydiary.presenter.main.MainPresenter
import com.hackathon.happydiary.view.main.ui.MainUI
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.toast
import org.koin.android.ext.android.get

class MainActivity: BaseActivity<MainConstract.View, MainPresenter>(), MainConstract.View, View.OnClickListener {

    lateinit var mAdapter: MainPagerAdapter

    override var layout: AnkoComponent<Activity> = MainUI()
    override fun onCreatePresenter(): MainPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(layout as MainUI) {

            with(vp) {
                addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) { }
                    override fun onPageScrollStateChanged(state: Int) { }
                    override fun onPageSelected(position: Int) {
                        initTabPosition(position)
                    }
                })
            }

            initTabPosition()

            presenter?.run {
                // initFragments()
                vp.adapter = MainPagerAdapter(supportFragmentManager, initFragmentMap()).apply {
                }.also { mAdapter = it }
            }

            tabs.forEach { it.setOnClickListener(this@MainActivity) }
            writeBtn.setOnClickListener(this@MainActivity)
        }
    }

    override fun initTabPosition(position: Int) {
        with(layout as MainUI) {
            when(position) {
                0 -> {
                    tabIvs[0].backgroundResource = R.drawable.ic_me_img_on
                    tabIvs[1].backgroundResource = R.drawable.ic_we_img
                    vp.currentItem = 0
                }
                1 -> {
                    tabIvs[0].backgroundResource = R.drawable.ic_me_img
                    tabIvs[1].backgroundResource = R.drawable.ic_we_img_on
                    vp.currentItem = 1
                }
                else -> {}
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.my_diary_list -> initTabPosition(0)
            R.id.diary_write -> toast("행복찾기")
            R.id.other_diary_list -> initTabPosition(1)
            else -> {}
        }
    }

}