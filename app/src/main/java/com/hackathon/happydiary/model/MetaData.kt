package com.hackathon.happydiary.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MetaData (

    @SerializedName("is_end")
    var isEnd: Boolean = false,

    @SerializedName("pageable_count")
    var pageableCount: Int = 0,

    @SerializedName("total_count")
    var totalCount: Int = 0

): Parcelable