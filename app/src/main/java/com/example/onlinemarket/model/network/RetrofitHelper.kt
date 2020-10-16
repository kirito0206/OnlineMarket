package com.example.onlinemarket.model.network

import com.example.onlinemarket.model.network.services.MarketService
import com.example.onlinemarket.model.network.services.UserService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    const val USER_URL = ""

    val userService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(USER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return@lazy retrofit.create(UserService::class.java)
    }

    val marketService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(USER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return@lazy retrofit.create(MarketService::class.java)
    }
}