package com.example.sportapitask.internal

import com.example.sportapitask.data.models.*
import com.example.sportapitask.data.models.domain.*

class MapperHelper {
    companion object{
         fun mapNetworkAthleteToAthleteModel(networkAthleteModel: NetworkAthleteModel): AthleteModel {
            return AthleteModel(
                networkAthleteModel.age,
                networkAthleteModel.avatar,
                networkAthleteModel.club,
                mapNetworkCountryToCountryModel(networkAthleteModel.country),
                networkAthleteModel.name,
                mapNetworkSportToSportModel(networkAthleteModel.sport)
            )
        }

         fun mapNetworkCountryToCountryModel(networkCountryModel: NetworkCountryModel): CountryModel {
            return CountryModel(
                networkCountryModel.icon,
                networkCountryModel.name
            )
        }

         fun mapNetworkSportToSportModel(networkSportModel: NetworkSportModel): SportModel {
            return SportModel(networkSportModel.name)
        }

         fun mapListNetworkFeedToListFeedModel(listNetworkFeedModel: List<NetworkFeedModel>): List<FeedModel> =
            listNetworkFeedModel.map { mapNetworkFeedToFeedModel(it) }

         fun mapNetworkFeedToFeedModel(networkFeedModel: NetworkFeedModel): FeedModel {
            return FeedModel(
                video = mapNetworkVideoToVideoModel(networkFeedModel.video),
                description = networkFeedModel.description,
                views = networkFeedModel.views,
                athlete = mapNetworkAthleteToAthleteModel(networkFeedModel.athlete)
            )
        }

         fun mapNetworkVideoToVideoModel(networkVideo: NetworkVideoModel): VideoModel {
            return VideoModel(poster = networkVideo.poster, url = networkVideo.url)
        }
    }
}