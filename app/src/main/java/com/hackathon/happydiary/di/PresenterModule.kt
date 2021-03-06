package com.hackathon.happydiary.di

import com.hackathon.happydiary.presenter.intro.IntroPresenter
import com.hackathon.happydiary.presenter.main.MainPresenter
import com.hackathon.happydiary.presenter.main.my.MyDiaryPresenter
import com.hackathon.happydiary.presenter.main.we.WeDiaryPresenter
import com.hackathon.happydiary.presenter.splash.SplashPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory { IntroPresenter(get()) }
    factory { SplashPresenter(get()) }
    factory { MainPresenter(get()) }
    factory { MyDiaryPresenter(get()) }
    factory { WeDiaryPresenter(get()) }
}