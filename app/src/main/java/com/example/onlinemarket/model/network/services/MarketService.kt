package com.example.onlinemarket.model.network.services

import com.example.onlinemarket.model.bean.*
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface MarketService {

    @GET("carousel/getall")
    suspend fun getBanners() : BannerResponse

    @GET("product/getall")
    suspend fun getProducts() : ProductResponse

    @FormUrlEncoded
    @POST("product/query")
    suspend fun getSingleProduct(@Field("token") token : String,@Field("productid") productid : Int) : ProductDetailResponse

    @GET("activity/getall")
    suspend fun getActions() : ActionResponse

    @FormUrlEncoded
    @POST("activity/query")
    suspend fun getSingleAction(@Field("token") token : String ,@Field("activityid") activityid : Int) : ActionDetailResponse

    @FormUrlEncoded
    @POST("product/recommend")
    suspend fun getRecommendProducts(@Field("token") token: String) : RecommendResponse
}