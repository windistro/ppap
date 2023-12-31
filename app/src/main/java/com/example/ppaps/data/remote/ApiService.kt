package com.example.ppaps.data.remote

import com.example.ppaps.data.response.CheckResponse
import com.example.ppaps.data.response.ConfirmationResponse
import com.example.ppaps.data.response.EmergencyVerifResponse
import com.example.ppaps.data.response.ListHospitalResponse
import com.example.ppaps.data.response.LoginResponse
import com.example.ppaps.data.response.RegisterResponse
import com.example.ppaps.data.response.Response
import com.example.ppaps.data.response.UserResponse
import com.example.ppaps.data.response.VerificationResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Url

interface ApiService {
    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("no_hp") no_hp: String,
        @Field("name") name: String
    ): Response

    @FormUrlEncoded
    @POST
    suspend fun registerBaru(
        @Url url: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("no_hp") no_hp: String,
        @Field("name") name: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ) : LoginResponse

    @FormUrlEncoded
    @POST
    suspend fun loginBaru(
        @Url url: String,
        @Field("username") username: String,
        @Field("password") password: String,
    ) : LoginResponse

    @GET("user/me")
    suspend fun getUser(
        @Header("Authorization") token: String,
    ): UserResponse

    @GET("hospitals")
    suspend fun listHospitals(
        @Header("Authorization") token: String,
    ): ListHospitalResponse

    @FormUrlEncoded
    @PUT("change-password")
    suspend fun changePassword(
        @Header("Authorization") token: String,
        @Field("oldPassword") oldPass: String,
        @Field("newPassword") newPass: String,
        @Field("confirmNewPassword") newPassConfirm: String,
        ): Response

    @POST("pesan")
    suspend fun order(
        @Header("Authorization") token: String,
        @Field("id_rumah_sakit") hospitalId: String,
        @Field("tanggal") date: String,
    ): ListHospitalResponse

    @Multipart
    @POST
    suspend fun upload(
        @Header("Authorization") token: String,
        @Url url: String,
        @Part file: MultipartBody.Part,
        @Part("user_id") username: RequestBody,
    ) : VerificationResponse

    @Multipart
    @POST
    suspend fun verification(
        @Header("Authorization") token: String,
        @Url url: String,
        @Part file: MultipartBody.Part,
        @Part("user_id") user_id: RequestBody,
    ) : EmergencyVerifResponse

    @FormUrlEncoded
    @POST
    suspend fun confirmation(
        @Header("Authorization") token: String,
        @Url url: String,
        @Field("user_id") user_id: String,
    ) : ConfirmationResponse

    @FormUrlEncoded
    @POST
    suspend fun check(
        @Header("Authorization") token: String,
        @Url url: String,
        @Field("user_id") user_id: String,
    ) : CheckResponse
}