package com.hackathon.happydiary.view.diary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.happydiary.view.diary.ui.DiaryUI

class DiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(DiaryUI()) {
            setContentView(createView(org.jetbrains.anko.AnkoContext.create(this@DiaryActivity, this@DiaryActivity)))
        }
    }

}