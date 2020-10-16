package com.example.onlinemarket.model.bean

data class BannerResponse(
    val `data`: BannerData,
    val status: Int
)

data class BannerData(
    val pictures: List<String>
)