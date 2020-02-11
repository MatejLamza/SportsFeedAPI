package com.example.sportapitask.data.repositories

import androidx.lifecycle.LiveData
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.network.ApiaryDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiaryRepoImpl
    @Inject constructor(val apiaryDS:ApiaryDataSource):ApiaryRepo {

    //TODO MAPPER
    override suspend fun fetchFeed(): LiveData<List<NetworkFeedModel>> {
        return withContext(Dispatchers.IO){
            apiaryDS.fetchFeed()
            return@withContext apiaryDS.fetchedFeed
        }
    }
}