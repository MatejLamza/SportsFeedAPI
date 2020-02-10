package com.example.sportapitask.data.models


import com.google.gson.annotations.SerializedName

data class NetworkFeedModel(
    var athlete: Athlete,
    var author: Author,
    var bookmarked: Boolean,
    var createdAt: String,
    var createdBefore: String,
    var description: String,
    @SerializedName("description `# #leomessi #pepe #neymar #sergioramos #championsleague`")
    var descriptionLeomessiPepeNeymarSergioramosChampionsleague: String,
    var id: Int,
    var sportGroup: SportGroup,
    var video: Video,
    var views: String
)