package com.hackathon.happydiary.view.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.hackathon.happydiary.BuildConfig
import com.hackathon.happydiary.R
import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.adapter.splash.SplashAdapter
import com.hackathon.happydiary.base.BaseActivity
import com.hackathon.happydiary.presenter.splash.SplashConstract
import com.hackathon.happydiary.presenter.splash.SplashPresenter
import com.hackathon.happydiary.utils.DLog
import com.hackathon.happydiary.view.main.MainActivity
import com.hackathon.happydiary.view.splash.ui.SplashUI
import com.kakao.sdk.common.util.Utility
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.backgroundResource
import org.koin.android.ext.android.get

class SplashActivity: BaseActivity<SplashConstract.View, SplashPresenter>(), SplashConstract.View, View.OnClickListener {

    lateinit var mAdapter: SplashAdapter

    override var layout: AnkoComponent<Activity> = SplashUI()
    override fun onCreatePresenter(): SplashPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(layout as SplashUI) {

            with(vp) {
                adapter = SplashAdapter(this@SplashActivity)
                    .also { mAdapter = it }
                registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        when(position) {
                            0 -> {
                                ind01.backgroundResource = R.drawable.ic_splash_indicator
                                ind02.backgroundResource = R.drawable.ic_splash_indicator_off
                                ind03.backgroundResource = R.drawable.ic_splash_indicator_off
                                contentTv.text = resources.getString(R.string.splash_content01_str)
                            }
                            1 -> {
                                ind01.backgroundResource = R.drawable.ic_splash_indicator_off
                                ind02.backgroundResource = R.drawable.ic_splash_indicator
                                ind03.backgroundResource = R.drawable.ic_splash_indicator_off
                                contentTv.text = resources.getString(R.string.splash_content02_str)
                            }
                            else -> {
                                ind01.backgroundResource = R.drawable.ic_splash_indicator_off
                                ind02.backgroundResource = R.drawable.ic_splash_indicator_off
                                ind03.backgroundResource = R.drawable.ic_splash_indicator
                                contentTv.text = resources.getString(R.string.splash_content03_str)
                            }
                        }
                    }
                })
            }

            presenter?.run {
                adapterView = mAdapter
                adapterModel = mAdapter

                // splash ????????? ????????????
                getSplashImgs()
            }

            mKakaoLoginBtn.setOnClickListener(this@SplashActivity)
        }
        getKeyHash()
    }

    private fun getKeyHash() {
        if (BuildConfig.DEBUG) Utility.getKeyHash(this).let {
            DLog.e("KEY_HASH", it)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.splash_kakao_btn -> kakaoLogin()
            else -> {}
        }
    }

    override fun kakaoLogin() {
        presenter?.run {
            kakaoLogin { kakaoToken, error ->
                if (kakaoToken != null) getKakaoUserInfo { user, error ->
                    user?.run {

                        /**
                         * ?????? ????????? ???????????? ??????????????? API??? ????????????????????????
                         * 1. ????????? ????????? ?????? API ( ???????????? ?????? )
                         * 2. ????????? ????????? ?????? ????????? API ??????
                         * 3. ???????????? ?????? ????????? ??????, ???????????? API ?????? ?????? ????????? API ??????
                         *
                         * ?????? ?????? ?????? API??? ?????? ??????????????? ?????? ?????? ??????
                         */
                        val identifier = id
                        pref.setOAuthId(identifier)
                        DLog.e("kakaoLogin", "$identifier")

                        requestLogin(identifier) { status, response ->

                            /**
                             * status
                             * 200 : ?????? ?????????
                             * 201 : ?????? ?????????
                             */
                            when(status) {
                                StatusConst.SUCCESS -> moveMainPage()
                                else -> response.data?.let {
                                    pref.setAuthorization(it.accessToken)
                                    moveUserProfilePage()
                                }
                            }
                        }
//                        movePage({
//                            Intent(this@SplashActivity, MainActivity::class.java)
//                                .let(this@SplashActivity::startActivity)
//                        }, 2000L)
                    }
                }
            }
        }
    }

    override fun moveUserProfilePage() {
//        Intent(this@SplashActivity, UserProfileActivity::class.java)
//            .let(this::startActivity)
//        finish()
    }

    override fun moveMainPage() {
        Intent(this@SplashActivity, MainActivity::class.java)
            .let(this::startActivity)
        finish()
    }

}