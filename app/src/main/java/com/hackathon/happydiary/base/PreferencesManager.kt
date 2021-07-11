package com.hackathon.happydiary.base

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.hackathon.happydiary.AppConst.AUTHORIZATION_KEY
import com.hackathon.happydiary.AppConst.LOGIN_ID
import com.hackathon.happydiary.AppConst.OAUTHID_KEY
import com.hackathon.happydiary.AppConst.USER_ID_KEY
import com.hackathon.happydiary.AppConst.USER_NAME_KEY

class PreferencesManager(ctx: Context, name: String = "pref") {

    private val pref : SharedPreferences = ctx.getSharedPreferences(name, Activity.MODE_PRIVATE)
    private val saver : SharedPreferences.Editor = pref.edit()

    fun getAuthorization(): String = pref.getString(AUTHORIZATION_KEY, "") ?: ""
    fun setAuthorization(token: String) {
        saver.putString(AUTHORIZATION_KEY, token)
        saver.commit()
    }

    fun getOAuthId(): Long = pref.getLong(OAUTHID_KEY, 0L) ?: 0L
    fun setOAuthId(oauthId: Long) {
        saver.putLong(OAUTHID_KEY, oauthId)
        saver.commit()
    }

    fun getUserId(): Int = pref.getInt(USER_ID_KEY, 0)
    fun setUserId(userId: Int) {
        saver.putInt(USER_ID_KEY, userId)
        saver.commit()
    }

    fun getLoginId(): Long = pref.getLong(LOGIN_ID, 0)
    fun setLoginId(loginId: Long) {
        saver.putLong(LOGIN_ID, loginId)
        saver.commit()
    }

    fun getUserName(): String = pref.getString(USER_NAME_KEY, "") ?: ""
    fun setUserName(userName: String) {
        saver.putString(USER_NAME_KEY, userName)
        saver.commit()
    }

    fun isLogin(): Boolean = getAuthorization().isNotEmpty()
    fun logout() {
        saver.remove(AUTHORIZATION_KEY)
        saver.remove(USER_ID_KEY)
        saver.remove(LOGIN_ID)
        saver.commit()
    }

}