package com.example.onlinemarket.model.bean

data class BannerResponse(
    val `data`: BannerData,
    val status: Int
)

data class BannerData(
    val message: BannerMessage
)

data class BannerMessage(
    val picture: List<String>,
    val type: Any
)