package com.hackathon.happydiary

import androidx.multidex.MultiDexApplication
import com.hackathon.happydiary.di.presenterModule
import com.hackathon.happydiary.di.apiModule
import com.hackathon.happydiary.di.networkModule
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
                apiModule,
                presenterModule
            ))
        }

    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }

}