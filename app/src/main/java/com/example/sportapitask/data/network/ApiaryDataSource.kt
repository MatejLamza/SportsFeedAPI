package com.example.sportapitask.data.network

import androidx.lifecycle.LiveData
import com.example.sportapitask.data.models.NetworkAthleteModel
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.models.domain.AthleteModel

interface ApiaryDataSource {
    suspend fun fetchFeed():List<NetworkFeedModel>
    suspend fun fetchAthlete():NetworkAthleteModel
}