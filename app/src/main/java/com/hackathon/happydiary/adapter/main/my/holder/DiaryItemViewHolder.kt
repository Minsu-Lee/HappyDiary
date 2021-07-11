package com.hackathon.happydiary.adapter.main.my.holder

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hackathon.happydiary.R
import com.hackathon.happydiary.adapter.main.my.ui.DiaryItemUI
import com.hackathon.happydiary.base.BaseViewHolder
import com.hackathon.happydiary.model.DiaryData
import com.hackathon.happydiary.view.component.SquareImageView

class DiaryItemViewHolder(parent: ViewGroup, val ui: DiaryItemUI): BaseViewHolder(parent, ui) {

    fun onBind(list: ArrayList<DiaryData>, position: Int) {
        with(ui) {
            list[position].let { item ->

                Glide.with(ctx)
                    .load(item.profileUrl)
                    .into(profileIv)

                userNickName.text = item.nickname

                Glide.with(ctx)
                    .load(item.imageUrl)
                    .into(contentIv)

                item.weather
                item.content

                likeCntTv.text = "${item.likeCount}"
                commentCntTv.text = "${item.commentCount}"
                lockLl.visibility = if (item.open) View.VISIBLE else View.GONE

                Glide.with(ctx)
                    .load(item.weather)

//                lateinit var weatherIv: SquareImageView
//                lateinit var weatherTv: TextView
//                lateinit var contentTv: TextView
//                lateinit var hashtagTv: TextView
//                lateinit var dateTv: TextView

                likeLl.setOnClickListener {  }
                commentLl.setOnClickListener {  }
                lockLl.setOnClickListener {  }
                menuLl.setOnClickListener {  }

//        lateinit var linkeLl: LinearLayout
//        lateinit var commentLl: LinearLayout
//        lateinit var lockLl: LinearLayout
//        lateinit var menuLl: LinearLayout
            }
        }
    }
}