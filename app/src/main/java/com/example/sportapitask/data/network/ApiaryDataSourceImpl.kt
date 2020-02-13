package com.example.sportapitask.data.network

import com.example.sportapitask.data.models.NetworkAthleteModel
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.network.services.ApiaryService
import javax.inject.Inject

class ApiaryDataSourceImpl
@Inject constructor(val apiaryService: ApiaryService) : ApiaryDataSource {

    override suspend fun fetchAthlete(): NetworkAthleteModel {
        return apiaryService.getAthlete().await()
    }

    override suspend fun fetchFeed():List<NetworkFeedModel> {
        return apiaryService.getFeed().await()
    }
}