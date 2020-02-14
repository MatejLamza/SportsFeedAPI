package com.example.sportapitask.data.repositories

import com.example.sportapitask.data.database.ApiaryDAO
import com.example.sportapitask.data.models.*
import com.example.sportapitask.data.models.domain.*
import com.example.sportapitask.data.network.ApiaryDataSource
import com.example.sportapitask.internal.MapperHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiaryRepoImpl
@Inject constructor(val apiaryDS: ApiaryDataSource,
                    val apiaryDAO: ApiaryDAO) : ApiaryRepo {

    override suspend fun upsertFeed(feedModel: List<FeedModel>) {
        GlobalScope.launch(Dispatchers.IO) {
            apiaryDAO.upsertFeed(feedModel)
        }
    }

    override suspend fun getFeedFromCache(): List<FeedModel> {
        return withContext(Dispatchers.IO){
            return@withContext apiaryDAO.getFeedFromCache()
        }
    }

    override suspend fun fetchAthlete(): AthleteModel {
        return withContext(Dispatchers.IO) {
            return@withContext MapperHelper.mapNetworkAthleteToAthleteModel(apiaryDS.fetchAthlete())
        }
    }

    override suspend fun fetchFeed(): List<FeedModel> {
        return withContext(Dispatchers.IO) {
            return@withContext MapperHelper.mapListNetworkFeedToListFeedModel(apiaryDS.fetchFeed())
        }
    }
}