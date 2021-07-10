package com.hackathon.happydiary.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageData (

    @SerializedName("collection")
    var collection: String = "",

    @SerializedName("datetime")
    var datetime: String = "",
    // [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]

    @SerializedName("display_sitename")
    var displaySitename: String = "",

    @SerializedName("doc_url")
    var docUrl: String = "",

    @SerializedName("width")
    var width: Int = 0,

    @SerializedName("height")
    var height: Int = 0,

    @SerializedName("image_url")
    var image_url: String = "",

    @SerializedName("thumbnail_url")
    var thumbnailUrl: String = ""

): Parcelable