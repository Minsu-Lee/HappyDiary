package com.hackathon.happydiary.view.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.hackathon.happydiary.BuildConfig
import com.hackathon.happydiary.R
import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.base.BaseActivity
import com.hackathon.happydiary.presenter.splash.SplashConstract
import com.hackathon.happydiary.presenter.splash.SplashPresenter
import com.hackathon.happydiary.utils.DLog
import com.hackathon.happydiary.view.main.MainActivity
import com.hackathon.happydiary.view.splash.ui.SplashUI
import com.kakao.sdk.common.util.Utility
import org.jetbrains.anko.AnkoComponent
import org.koin.android.ext.android.get

class SplashActivity: BaseActivity<SplashConstract.View, SplashPresenter>(), SplashConstract.View, View.OnClickListener {

    override var layout: AnkoComponent<Activity> = SplashUI()
    override fun onCreatePresenter(): SplashPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(layout as SplashUI) {
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
                         * 일단 납득은 안가지만 아래순으로 API를 호출해야될것같음
                         * 1. 이메일 아이디 찾기 API ( 가입유무 판별 )
                         * 2. 가입된 유저의 경우 로그인 API 호출
                         * 3. 가입되지 않은 유저의 경우, 회원가입 API 호출 이후 로그인 API 호출
                         *
                         * 아직 가입 유무 API를 개발 진행중이라 향후 로직 개발
                         */
                        val identifier = id
                        DLog.e("kakaoLogin", "$identifier")

                        requestLogin(identifier) { status, response ->

                            /**
                             * status
                             * 200 : 기존 사용자
                             * 201 : 신규 사용자
                             */
                            when(status) {
                                StatusConst.SUCCESS -> moveMainPage()
                                else -> response.data?.let {
                                    pref.setAuthorization(it.accessToken)
                                    moveUserProfilePage()
                                }
                            }
                        }
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