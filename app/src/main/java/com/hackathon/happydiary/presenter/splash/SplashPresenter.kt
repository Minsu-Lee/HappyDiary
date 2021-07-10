package com.hackathon.happydiary.presenter.splash

import com.hackathon.happydiary.R
import com.hackathon.happydiary.StatusConst
import com.hackathon.happydiary.adapter.sample.SampleAdapterConstract
import com.hackathon.happydiary.adapter.splash.SplashAdapterConstract
import com.hackathon.happydiary.base.AbstractPresenter
import com.hackathon.happydiary.model.LogInData
import com.hackathon.happydiary.model.Response
import com.hackathon.happydiary.network.UserAPIService
import com.hackathon.happydiary.utils.DLog
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SplashPresenter(val userApi: UserAPIService): AbstractPresenter<SplashConstract.View>(), SplashConstract.Presenter {

    override var adapterView: SplashAdapterConstract.View? = null
    override var adapterModel: SplashAdapterConstract.Model? = null

    override fun getSplashImgs(callback: ((ArrayList<Int>) -> Unit)?) {
        arrayListOf(
            R.drawable.bg_splash_01,
            R.drawable.bg_splash_02,
            R.drawable.bg_splash_03).let {
                callback?.invoke(it)
                adapterModel?.initData(it)
                adapterView?.notifyAdapter()
            }
    }

    override fun kakaoLogin(callback: (token: OAuthToken?, error: Throwable?) -> Unit) {
        procKakaoLogin { kakaoToken, error ->
            if (error != null) DLog.e("LoginPresenter", "로그인 실패", error)
            else if (kakaoToken != null) {
                DLog.e("LoginPresenter", "로그인 성공 ${kakaoToken.accessToken}")
            }
            callback(kakaoToken, error)
        }
    }
    private fun procKakaoLogin(callback: (token: OAuthToken?, error: Throwable?) -> Unit) {
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(ctx)) {
            UserApiClient.instance.loginWithKakaoTalk(context = ctx, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context = ctx, callback = callback)
        }
    }


    override fun getKakaoUserInfo(callback: (user: User?, error: Throwable?) -> Unit) {
        // 사용자 정보 요청 (기본)
        UserApiClient.instance.me { user, error ->
            if (error != null) DLog.e("UserUseCase", "사용자 정보 요청 실패", error)
            else if (user != null) {
                DLog.e("UserUseCase", "사용자 정보 요청 성공" +
                        "\n회원번호: ${user.id}" +
                        "\n이메일: ${user.kakaoAccount?.email}" +
                        "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                        "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")
            }
            callback(user, error)
        }
    }

    /**
     * status
     * 200 : 기존 사용자
     * 201 : 신규 사용자
     */
    override fun requestLogin(socialId: Long, callback: (Int, Response<LogInData>) -> Unit) {
        userApi.socialLogin(socialId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (it.status) {
                    StatusConst.SUCCESS or StatusConst.SUCCESS201 -> callback(it.status, it)
                    else -> log("validToken", it.message)
                }
            }, this::handleError)
    }
}