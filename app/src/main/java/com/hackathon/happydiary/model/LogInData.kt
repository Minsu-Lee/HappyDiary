package com.hackathon.happydiary.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LogInData (

    @SerializedName("accessToken")
    var accessToken: String = ""): Parcelable