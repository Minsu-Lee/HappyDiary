package com.hackathon.happydiary.adapter.sample.holder

import android.view.ViewGroup
import com.hackathon.happydiary.R
import com.hackathon.happydiary.adapter.sample.ui.SampleUI
import com.hackathon.happydiary.base.BaseViewHolder

class SampleViewHolder(parent: ViewGroup, val ui: SampleUI): BaseViewHolder(parent, ui) {

    fun onBind(position: Int) = with(ui) {
        sampleTv.setOnClickListener {
            positionCallback(R.id.sample_text, position)
        }
    }
}