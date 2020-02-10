package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class Sport(
    var icon: String,
    var id: Int,
    var name: String,
    var slug: String
)