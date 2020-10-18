package com.example.onlinemarket.model.network.services

import com.example.onlinemarket.model.bean.CommonResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(@Field("username") name : String, @Field("password") password : String) : CommonResponse

    @FormUrlEncoded
    @POST("logout")
    suspend fun logout(@Field("token") token : String) : CommonResponse
}