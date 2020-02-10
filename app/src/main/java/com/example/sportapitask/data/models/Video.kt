package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class Video(
    var handler: String,
    var length: Int,
    var poster: String,
    var type: String,
    var url: String
)