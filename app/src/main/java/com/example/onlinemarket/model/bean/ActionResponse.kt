package com.example.onlinemarket.model.bean

import com.google.gson.annotations.SerializedName
import org.litepal.LitePalApplication
import org.litepal.crud.LitePalSupport

data class ActionResponse(
    val `data`: ActionData,
    val status: Int
)

data class ActionData(
    val activities: List<Action>
)

data class Action (
    @SerializedName(value = "id")
    val actionId: Int,
    val name: String,
    val time: String,
    val type: Int
) : LitePalSupport()