package com.example.sportapitask.data.repositories

import android.util.Log
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.models.NetworkVideoModel
import com.example.sportapitask.data.models.domain.FeedModel
import com.example.sportapitask.data.models.domain.VideoModel
import com.example.sportapitask.data.network.ApiaryDataSource
import com.example.sportapitask.internal.ListMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiaryRepoImpl
    @Inject constructor(val apiaryDS:ApiaryDataSource):ApiaryRepo {

    override suspend fun fetchFeed(): List<FeedModel> {
       return withContext(Dispatchers.IO){
           apiaryDS.fetchFeed()
           return@withContext mapListNetworkFeedToListFeedModel(apiaryDS.fetchedFeed.value!!)
       }
    }

    private fun mapListNetworkFeedToListFeedModel(listNetworkFeedModel: List<NetworkFeedModel>):List<FeedModel>
         = listNetworkFeedModel.map { mapNetworkFeedToFeedModel(it) }


    private fun mapNetworkFeedToFeedModel(networkFeedModel:NetworkFeedModel):FeedModel{
        val feedModel = FeedModel(video = mapNetworkVideoToVideoModel(networkFeedModel.video),description = networkFeedModel.description )
        return feedModel
    }

    private fun mapNetworkVideoToVideoModel(networkVideo:NetworkVideoModel):VideoModel{
        val videoModel = VideoModel(poster = networkVideo.poster,url = networkVideo.url)
        return videoModel
    }
}