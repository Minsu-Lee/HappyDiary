package com.hackathon.happydiary.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDiaryData(

    @SerializedName("user")
    val user: UserHappyInfo,

    @SerializedName("diary")
    val diary: ArrayList<DiaryData>) : Parcelable