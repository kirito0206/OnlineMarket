package com.example.onlinemarket.model.network.services

import com.example.onlinemarket.model.bean.*
import retrofit2.http.*

interface MarketService {

    @GET("carousel/getall")
    suspend fun getBanners() : BannerResponse

    @GET("product/getall")
    suspend fun getProducts() : ProductResponse

    @FormUrlEncoded
    @POST("product/query")
    suspend fun getSingleProduct(token : String , productid : Int) : ProductDetailResponse

    @GET("activity/getall")
    suspend fun getActions() : ActionResponse

    @FormUrlEncoded
    @POST("activity/query")
    suspend fun getSingleAction(token : String , activityid : Int) : ActionDetailResponse

    @FormUrlEncoded
    @POST("product/recommend")
    suspend fun getRecommendProducts(token: String) : RecommendResponse
}