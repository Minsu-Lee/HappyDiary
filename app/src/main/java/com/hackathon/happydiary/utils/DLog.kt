package com.hackathon.happydiary.utils

import android.util.Log
import com.hackathon.happydiary.BuildConfig

object DLog {

    var DEBUG_STATUS: Int = Int.MIN_VALUE

    fun v(tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.v(tag, msg) else DEBUG_STATUS

    fun v(tag: String?, msg: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && msg != null) Log.v(tag, msg, tr) else DEBUG_STATUS

    fun d(tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.d(tag, msg) else DEBUG_STATUS

    fun d(tag: String?, msg: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && msg != null) Log.d(tag, msg, tr) else DEBUG_STATUS

    fun i(tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.i(tag, msg) else DEBUG_STATUS

    fun i(tag: String?, msg: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && msg != null) Log.i(tag, msg, tr) else DEBUG_STATUS

    fun w(tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.w(tag, msg) else DEBUG_STATUS

    fun w(tag: String?, msg: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && msg != null) Log.w(tag, msg, tr) else DEBUG_STATUS

    fun w(tag: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && tr != null) Log.w(tag, tr) else DEBUG_STATUS

    fun e(tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.e(tag, msg) else DEBUG_STATUS

    fun e(tag: String?, msg: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && msg != null) Log.e(tag, msg, tr) else DEBUG_STATUS

    fun wtf(tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.wtf(tag, msg) else DEBUG_STATUS

    fun wtf(tag: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && tr != null) Log.wtf(tag, tr) else DEBUG_STATUS

    fun wtf(tag: String?, msg: String?, tr: Throwable?): Int = if (BuildConfig.DEBUG && msg != null) Log.wtf(tag, msg, tr) else DEBUG_STATUS

    fun println(priority: Int, tag: String?, msg: String?): Int = if (BuildConfig.DEBUG && msg != null) Log.println(priority, tag, msg) else DEBUG_STATUS

}