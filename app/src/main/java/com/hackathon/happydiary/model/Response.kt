package com.hackathon.happydiary.model

import com.google.gson.annotations.SerializedName
import com.hackathon.happydiary.StatusConst

class Response<T> (

    @SerializedName("status")
    var status: Int = StatusConst.SUCCESS,

    @SerializedName("message")
    var message: String = "",

    @SerializedName("data")
    var data: T? = null)