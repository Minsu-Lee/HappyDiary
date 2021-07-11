package com.hackathon.happydiary.adapter.main.my.holder

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.hackathon.happydiary.R
import com.hackathon.happydiary.adapter.main.my.ui.DiaryItemUI
import com.hackathon.happydiary.base.BaseViewHolder
import com.hackathon.happydiary.extensions.dateFormat
import com.hackathon.happydiary.extensions.toast
import com.hackathon.happydiary.model.DiaryData
import org.jetbrains.anko.dip
import java.util.*

class DiaryItemViewHolder(parent: ViewGroup, val ui: DiaryItemUI): BaseViewHolder(parent, ui) {

    fun onBind(list: ArrayList<DiaryData>, position: Int) {
        with(ui) {
            list[position].let { item ->

                Glide.with(ctx)
                    .load(item.profileUrl)
                    .circleCrop()
                    .into(profileIv)

                userNickName.text = item.nickname

                Glide.with(ctx)
                    .load(item.imageUrl)
                    .transform(CenterCrop(), RoundedCorners(ctx.dip(10)))
                    .into(contentIv)

                likeCntTv.text = "${item.likeCount}"
                commentCntTv.text = "${item.commentCount}"
                lockLl.visibility = if (item.open) View.VISIBLE else View.GONE

                when (item.weather) {
                    "1" -> Pair(R.drawable.ic_cloud_rain_img, "우울")
                    "2" -> Pair(R.drawable.ic_cloud_img, "보통")
                    "3" -> Pair(R.drawable.ic_sun_img, "맑음")
                    else -> Pair(R.drawable.ic_rainbow_img, "행복")
                }.let { weather ->

                    Glide.with(ctx)
                        .load(weather.first)
                        .into(weatherIv)

                    weatherTv.text = weather.second
                }

                contentTv.text = item.content

                (item.hashTag ?: "").let { hashTag ->
                    hashtagTv.visibility = if (hashTag.isEmpty()) View.INVISIBLE else View.VISIBLE
                    hashtagTv.text = hashTag
                }

                dateTv.text = Date().dateFormat("yyyy.MM.dd")

                likeLl.setOnClickListener { toast(ctx, "좋아요") }
                commentLl.setOnClickListener { toast(ctx, "댓글") }
                lockLl.setOnClickListener { toast(ctx, "잠금상태") }
                menuLl.setOnClickListener { toast(ctx, "메뉴") }

            }
        }
    }
}