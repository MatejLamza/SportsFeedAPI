package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class Athlete(
    var age: Int,
    var avatar: String,
    var club: String,
    var country: Country,
    var id: Int,
    var isCelebrity: Boolean,
    var name: String,
    var sport: Sport
)