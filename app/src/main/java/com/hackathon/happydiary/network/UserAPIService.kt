package com.hackathon.happydiary.network

import com.hackathon.happydiary.base.ApiUrl
import com.hackathon.happydiary.model.LogInData
import com.hackathon.happydiary.model.Response
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.*

interface UserAPIService {

    /**
     * 200 : 토큰 정상
     * 201 : 토큰 갱신
     * 600 : 신규사용자
     */
    @POST(ApiUrl.VALID_TOKEN)
    fun validToken(@Body token: String): Observable<Response<String>>

    @POST(ApiUrl.SOCIAL_LOGIN)
    fun socialLogin(@Body socialId: Long): Observable<Response<LogInData>>

    /**
     *
     * RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), nickname);
     *
     * // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
     * RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), Uri filePath);
     *
     * ArrayList<MultipartBody.Part> params = new ArrayList<>();
     * names.add(Multipart.Part.createFormData("nickname", "이민수"));
     * names.add(Multipart.Part.createFormData("photo", "photo.jpg", fileBody));
     *
     *
     * fun signup(@Part files: List<MultipartBody.Part>): Observable<String>
     */
    @Multipart
    @POST(ApiUrl.USER_INFO)
    fun updateUserInfo(@Part files: List<MultipartBody.Part>): Observable<Response<String>>

}