package com.hackathon.happydiary.di

import com.google.gson.GsonBuilder
import com.hackathon.happydiary.BuildConfig
import com.hackathon.happydiary.base.ApiUrl
import com.hackathon.happydiary.base.PreferencesManager
import com.hackathon.happydiary.extensions.applySSL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// TCP Handshake가 완료되기까지 지속되는 시간
const val CONNECTION_TIMEOUT: Long = 15
// 서버로부터 응답까지의 시간이 READ_TIMEOUT을 초과하면 실패로 간주
const val READ_TIMEOUT: Long = 15
// 클라이언트로 부터 서버로 응답을 보내는 시간이 WRITE_TIMEOUT을 초과하면 실패로 간주
const val WRITE_TIMEOUT: Long = 15

val networkModule = module {

    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    single { GsonBuilder().create() }

    single {
        OkHttpClient().newBuilder()
            .applySSL()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(get())
            .addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }).build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(ApiUrl.MAIN_DOMAIN)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        Interceptor { chain ->
            val pref: PreferencesManager = get()
            chain.proceed(chain.request().newBuilder().apply {
                header("accessToken", pref.getAuthorization())
            }.build())
        }
    }

}