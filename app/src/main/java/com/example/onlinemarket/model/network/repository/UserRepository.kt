package com.example.onlinemarket.model.network.repository

import com.example.onlinemarket.model.network.RetrofitHelper

class UserRepository {
    val userService = RetrofitHelper.userService

    suspend fun login(name : String,password : String) = userService.login(name, password)

    suspend fun logout(token : String) = userService.logout(token)
}