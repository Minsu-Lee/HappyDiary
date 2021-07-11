package com.hackathon.happydiary.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestData (

    @SerializedName("test1")
    var test1: String = "",

    @SerializedName("test2")
    var test2: String = ""): Parcelable