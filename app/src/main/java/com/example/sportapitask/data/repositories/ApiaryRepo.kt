package com.example.sportapitask.data.repositories


import com.example.sportapitask.data.models.domain.AthleteModel
import com.example.sportapitask.data.models.domain.FeedModel

interface ApiaryRepo {

    //Network
    suspend fun fetchFeed(): List<FeedModel>
    suspend fun fetchAthlete():AthleteModel

    //Local database
    suspend fun upsertFeed(feedModel: List<FeedModel>)
    suspend fun getFeedFromCache():List<FeedModel>
}