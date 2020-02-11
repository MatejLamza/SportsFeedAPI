package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class NetworkVideoModel(
    @SerializedName("length")
    var length: Int,
    @SerializedName("poster")
    var poster: String,
    @SerializedName("url")
    var url: String
)