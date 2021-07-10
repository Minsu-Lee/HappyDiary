package com.hackathon.happydiary.utils

import androidx.lifecycle.MutableLiveData

class NotNullMutableLiveData<T : Any>(defaultValue: T) : MutableLiveData<T>() {

    init {
        value = defaultValue
    }

    override fun getValue()  = super.getValue()!!
}