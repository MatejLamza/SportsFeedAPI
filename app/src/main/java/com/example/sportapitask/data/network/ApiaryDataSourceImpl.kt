package com.example.sportapitask.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.network.services.ApiaryService
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class ApiaryDataSourceImpl
@Inject constructor(val apiaryService: ApiaryService):ApiaryDataSource {

    private var _fetchedFeed = MutableLiveData<List<NetworkFeedModel>>()

    override val fetchedFeed: LiveData<List<NetworkFeedModel>>
        get() = _fetchedFeed

    override suspend fun fetchFeed() {
        try {
            val fetchedFeed = apiaryService.getFeed().await()
            _fetchedFeed.postValue(fetchedFeed)
        } catch (exception:Exception){
            Timber.d("ApiaryDSImpl fetchFeed exception: ${exception.message}")
        }
    }
}