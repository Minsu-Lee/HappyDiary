package com.hackathon.happydiary.utils

import android.content.Context
import android.graphics.Point
import android.view.View
import android.view.inputmethod.InputMethodManager
import org.jetbrains.anko.windowManager

object DeviceUtils {

    /**
     *  size.x = width, size.y = hegiht
     */
    fun getDeviceSize(context: Context): Point = with(context) {
        windowManager.defaultDisplay.let { display ->
            return Point().also { size ->
                display.getSize(size)
            }
        }
    }

    fun showKeyboard(context: Context, view : View) = with(context) {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let { inputMethodManager ->
            inputMethodManager.showSoftInput(view, 0)
        }
    }

    fun hideKeyboard(context: Context, view : View) = with(context) {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let { inputMethodManager ->
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}