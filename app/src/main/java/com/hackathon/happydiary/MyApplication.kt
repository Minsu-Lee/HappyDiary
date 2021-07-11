package com.hackathon.happydiary

import androidx.multidex.MultiDexApplication
import com.hackathon.happydiary.di.presenterModule
import com.hackathon.happydiary.di.apiModule
import com.hackathon.happydiary.di.commonModule
import com.hackathon.happydiary.di.networkModule
import com.kakao.sdk.common.KakaoSdk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MyApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)

            koin.loadModules(listOf(networkModule,
                commonModule,
                apiModule,
                presenterModule))
        }

        // Kakao SDK 초기화
        KakaoSdk.init(this, resources.getString(R.string.kakao_api_key))
    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }

}