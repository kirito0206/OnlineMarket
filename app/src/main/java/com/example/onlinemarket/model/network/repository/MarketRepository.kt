package com.example.onlinemarket.model.network.repository

import com.example.onlinemarket.model.network.RetrofitHelper

class MarketRepository {

    val marketService = RetrofitHelper.marketService

    suspend fun getBanners() = marketService.getBanners()

    suspend fun getProducts() = marketService.getProducts()

    suspend fun getSingleProduct(token : String , productId : Int) = marketService.getSingleProduct(token,productId)

    suspend fun getActions() = marketService.getActions()

    suspend fun getSingleAction(token : String , actionId : Int) = marketService.getSingleAction(token,actionId)
}