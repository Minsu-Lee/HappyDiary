package com.hackathon.happydiary.presenter.splash

import com.hackathon.happydiary.base.BasePresenter
import com.hackathon.happydiary.base.BaseView
import com.hackathon.happydiary.model.LogInData
import com.hackathon.happydiary.model.Response
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.model.User

interface SplashConstract {

    interface View: BaseView {
        fun kakaoLogin()
        fun moveUserProfilePage()
        fun moveMainPage()
    }

    interface Presenter: BasePresenter<View> {
        fun kakaoLogin(callback: (token: OAuthToken?, error: Throwable?) -> Unit)
        fun getKakaoUserInfo(callback: (user: User?, error: Throwable?) -> Unit)
        fun requestLogin(socialId: Long, callback: (Int, Response<LogInData>) -> Unit)
    }

}