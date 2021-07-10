package com.hackathon.happydiary.base

object ApiUrl {

    //http://3.36.37.161:8080/api/v2/test
    const val MAIN_DOMAIN = "http://3.36.37.161:8080"

    const val API_VERSION = "/api/v2"

    const val DIARY = "diary"

    const val VALID = "valid"

    const val TOKEN = "token"

    const val SOCIAL = "social"

    const val LIKE = "like"

    const val LOGIN = "login"

    const val INFO = "info"

    const val NICKNAME = "nickname"

    const val USER = "user"

    const val USERS = "users"

    const val COMMENT = "comment"

    const val SEARCH_IMAGE = "/$API_VERSION/search/image"

    const val VALID_TOKEN = "$API_VERSION/$VALID/$TOKEN"

    const val SOCIAL_LOGIN = "$API_VERSION/$SOCIAL/$LOGIN"

    const val USER_INFO = "$API_VERSION/$USER/$INFO"

    const val USERS_NICKNAME = "$API_VERSION/$USERS/$NICKNAME"

    // "$DIARY_COMMENT_DIARY/{diaryId}/$COMMENT"
    const val DIARY_COMMENT_DIARY = "$API_VERSION/$DIARY"

}