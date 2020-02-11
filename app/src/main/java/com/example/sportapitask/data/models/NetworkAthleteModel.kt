package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class NetworkAthleteModel(
    @SerializedName("age")
    var age: Int,
    @SerializedName("avatar")
    var avatar: String,
    @SerializedName("club")
    var club: String,
    @SerializedName("country")
    var country:NetworkCountryModel,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("sport")
    var sport: NetworkSportModel
)