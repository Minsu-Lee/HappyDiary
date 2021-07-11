package com.hackathon.happydiary.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiaryData(

    @SerializedName("commentCount")
    val commentCount: Int,

    @SerializedName("content")
    val content: String,

    @SerializedName("hashTag")
    val hashTag: Any,

    @SerializedName("id")
    val id: Int,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("likeCount")
    val likeCount: Int,

    @SerializedName("nickname")
    val nickname: Any,

    @SerializedName("open")
    val open: Boolean,

    @SerializedName("profileUrl")
    val profileUrl: Any,

    @SerializedName("weather")
    val weather: String): Parcelable