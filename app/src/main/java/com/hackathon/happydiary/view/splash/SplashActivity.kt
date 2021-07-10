package com.hackathon.happydiary.view.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.happydiary.view.splash.ui.SplashUI

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(SplashUI()) {
            setContentView(createView(org.jetbrains.anko.AnkoContext.create(this@SplashActivity, this@SplashActivity)))
        }
    }

}