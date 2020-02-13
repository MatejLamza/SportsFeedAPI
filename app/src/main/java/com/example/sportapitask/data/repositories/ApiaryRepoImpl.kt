package com.example.sportapitask.data.repositories

import com.example.sportapitask.data.database.ApiaryDAO
import com.example.sportapitask.data.models.*
import com.example.sportapitask.data.models.domain.*
import com.example.sportapitask.data.network.ApiaryDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiaryRepoImpl
@Inject constructor(val apiaryDS: ApiaryDataSource,val apiaryDAO: ApiaryDAO) : ApiaryRepo {

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
            return@withContext mapNetworkAthleteToAthleteModel(apiaryDS.fetchAthlete())
        }
    }

    override suspend fun fetchFeed(): List<FeedModel> {
        return withContext(Dispatchers.IO) {
            return@withContext mapListNetworkFeedToListFeedModel(apiaryDS.fetchFeed())
        }
    }

    private fun mapNetworkAthleteToAthleteModel(networkAthleteModel: NetworkAthleteModel): AthleteModel {
        return AthleteModel(
            networkAthleteModel.age,
            networkAthleteModel.avatar,
            networkAthleteModel.club,
            mapNetworkCountryToCountryModel(networkAthleteModel.country),
            networkAthleteModel.name,
            mapNetworkSportToSportModel(networkAthleteModel.sport)
        )
    }

    private fun mapNetworkCountryToCountryModel(networkCountryModel: NetworkCountryModel): CountryModel {
        return CountryModel(
            networkCountryModel.icon,
            networkCountryModel.id,
            networkCountryModel.name
        )
    }

    private fun mapNetworkSportToSportModel(networkSportModel: NetworkSportModel): SportModel {
        return SportModel(networkSportModel.name)
    }

    private fun mapListNetworkFeedToListFeedModel(listNetworkFeedModel: List<NetworkFeedModel>): List<FeedModel> =
        listNetworkFeedModel.map { mapNetworkFeedToFeedModel(it) }

    private fun mapNetworkFeedToFeedModel(networkFeedModel: NetworkFeedModel): FeedModel {
        return FeedModel(
            video = mapNetworkVideoToVideoModel(networkFeedModel.video),
            description = networkFeedModel.description
        )
    }

    private fun mapNetworkVideoToVideoModel(networkVideo: NetworkVideoModel): VideoModel {
        return VideoModel(poster = networkVideo.poster, url = networkVideo.url)
    }
}