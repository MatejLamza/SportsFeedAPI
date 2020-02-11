package com.example.sportapitask.data.repositories

import androidx.lifecycle.LiveData
import com.example.sportapitask.data.models.NetworkFeedModel

interface ApiaryRepo {
    //Network
    //TODO Change to domain model
    suspend fun fetchFeed(): LiveData<List<NetworkFeedModel>>
}