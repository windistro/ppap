package com.example.ppaps.data.remote

import com.example.ppaps.data.response.LoginResponse
import com.example.ppaps.data.response.Response
import com.example.ppaps.data.response.UserResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("nohp") nohp: String,
        @Field("name") name: String
    ): Response

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ) : LoginResponse

    @GET("stories")
    suspend fun getUser(
        @Header("Authorization") token: String,
    ): UserResponse
}