package com.hackathon.happydiary.view.intro

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.base.BaseActivity
import com.hackathon.happydiary.presenter.intro.IntroConstract
import com.hackathon.happydiary.presenter.intro.IntroPresenter
import com.hackathon.happydiary.view.intro.ui.IntroUI
import com.hackathon.happydiary.view.main.MainActivity
import com.hackathon.happydiary.view.splash.SplashActivity
import org.jetbrains.anko.AnkoComponent
import org.koin.android.ext.android.get

class IntroActivity: BaseActivity<IntroConstract.View, IntroPresenter>(), IntroConstract.View {

    override var layout: AnkoComponent<Activity> = IntroUI()
    override fun onCreatePresenter(): IntroPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        validToken()
    }

    private fun validToken() {
        /**
         * 토큰 검사
         */
        presenter?.validToken { status, response ->

            when (status) {
                // 신규 사용자
                StatusConst.NEW_USER -> movePage(this::moveSplashPage)
                // 토큰 정상 or 토큰 갱신, 메인으로 이동
                StatusConst.SUCCESS, StatusConst.SUCCESS201 -> {
                    response.data?.let { pref.setAuthorization(it.accessToken) }
                    movePage(this::moveMainPage)
                }
            }
        } ?: movePage(this::moveSplashPage)
    }

    override fun moveSplashPage(time: Long) {
        Intent(this@IntroActivity, SplashActivity::class.java)
            .let(this::startActivity)
        finish()
    }

    override fun moveMainPage(time: Long) {
        Intent(this@IntroActivity, MainActivity::class.java)
            .let(this::startActivity)
        finish()
    }

    override fun onBackPressed() { }

}