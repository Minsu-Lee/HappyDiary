package com.hackathon.happydiary.network

import com.hackathon.happydiary.base.ApiUrl
import com.hackathon.happydiary.model.DiaryData
import com.hackathon.happydiary.model.Response
import com.hackathon.happydiary.model.UserDiaryData
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DiaryAPIService {

    @GET(ApiUrl.USER_DIARY)
    fun requestMyDiary(): Observable<Response<UserDiaryData>>

    /**
     * 200 : 토큰 정상
     * 201 : 토큰 갱신
     * 600 : 신규사용자
     */
//    @POST(ApiUrl.VALID_TOKEN)
//    fun validToken(): Observable<Response<String>>
//
//    @POST(ApiUrl.SOCIAL_LOGIN)
//    fun socialLogin(@Field("socialId") socialId: Long): Observable<Response<LogInData>>
//
//    @FormUrlEncoded
//    @POST(ApiUrl.TEST)
//    fun test(@Field("test1") test1: String, @Field("test2") test2: String): Observable<Response<TestData>>

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
    fun updateUserInfo(@Part files: List<MultipartBody.Part>): Observable<Response<DiaryData>>

}