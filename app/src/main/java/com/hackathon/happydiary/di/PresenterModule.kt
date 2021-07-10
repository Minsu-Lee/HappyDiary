package com.hackathon.happydiary.di

import com.hackathon.happydiary.presenter.MainPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory { MainPresenter() }
}