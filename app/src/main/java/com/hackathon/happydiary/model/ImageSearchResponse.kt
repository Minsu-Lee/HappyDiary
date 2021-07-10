package com.hackathon.happydiary.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageSearchResponse(

    @SerializedName("documents")
    var documents: ArrayList<ImageData> = arrayListOf(),

    @SerializedName("meta")
    var meta: MetaData? = null,

    @SerializedName("errorType")
    var errorType: String? = null,

    @SerializedName("message")
    var message: String? = null

): Parcelable