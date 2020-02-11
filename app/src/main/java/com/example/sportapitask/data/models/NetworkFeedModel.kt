package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class NetworkFeedModel(
    @SerializedName("athlete")
    var athlete: NetworkAthleteModel,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("video")
    var video: NetworkVideoModel,
    @SerializedName("views")
    var views: String
)