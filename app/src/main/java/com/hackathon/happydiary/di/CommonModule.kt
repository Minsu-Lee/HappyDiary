package com.hackathon.happydiary.di

import com.hackathon.happydiary.base.PreferencesManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonModule = module {

    single { PreferencesManager(androidApplication()) }

}