package com.hackathon.happydiary.di

import com.hackathon.happydiary.network.KakaoAPIService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(KakaoAPIService::class.java) }
}