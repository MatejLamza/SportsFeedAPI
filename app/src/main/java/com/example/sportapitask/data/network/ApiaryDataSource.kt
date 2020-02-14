package com.example.sportapitask.data.network

import com.example.sportapitask.data.models.NetworkAthleteModel
import com.example.sportapitask.data.models.NetworkFeedModel

interface ApiaryDataSource {
    suspend fun fetchFeed():List<NetworkFeedModel>
    suspend fun fetchAthlete():NetworkAthleteModel
}