package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class NetworkSportModel(
    @SerializedName("icon")
    var icon: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)