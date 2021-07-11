package com.hackathon.happydiary.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserHappyInfo(

    @SerializedName("level")
    val level: Int,

    @SerializedName("levelupCount")
    val levelupCount: Int,

    @SerializedName("userWriteCount")
    val userWriteCount: Int) : Parcelable