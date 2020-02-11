package com.example.sportapitask.data.network

import androidx.lifecycle.LiveData
import com.example.sportapitask.data.models.NetworkFeedModel

interface ApiaryDataSource {
    val fetchedFeed:LiveData<List<NetworkFeedModel>>

    suspend fun fetchFeed()
}