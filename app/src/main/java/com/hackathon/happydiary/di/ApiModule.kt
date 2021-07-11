package com.hackathon.happydiary.di

import com.hackathon.happydiary.network.DiaryAPIService
import com.hackathon.happydiary.network.UserAPIService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(UserAPIService::class.java) }
    single { get<Retrofit>().create(DiaryAPIService::class.java) }
}