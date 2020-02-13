package com.example.sportapitask.data.network

import androidx.lifecycle.LiveData
import com.example.sportapitask.data.models.NetworkAthleteModel
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.models.domain.AthleteModel

interface ApiaryDataSource {
    val fetchedFeed:LiveData<List<NetworkFeedModel>>
    val fetchedAthlete:LiveData<NetworkAthleteModel>

    suspend fun fetchFeed()
    suspend fun fetchAthlete()
}