package com.example.sportapitask.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sportapitask.data.models.NetworkAthleteModel
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.network.services.ApiaryService
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class ApiaryDataSourceImpl
@Inject constructor(val apiaryService: ApiaryService):ApiaryDataSource {

    private var _fetchedAthlete = MutableLiveData<NetworkAthleteModel>()
    private var _fetchedFeed = MutableLiveData<List<NetworkFeedModel>>()

    override val fetchedAthlete: LiveData<NetworkAthleteModel>
        get() = _fetchedAthlete

    override val fetchedFeed: LiveData<List<NetworkFeedModel>>
        get() = _fetchedFeed

    override suspend fun fetchAthlete() {
        try {
            val fetchedAthlete = apiaryService.getAthlete().await()
            _fetchedAthlete.postValue(fetchedAthlete)
        } catch (exception:Exception){
            Timber.d("ApiaryDSImpl fetchAthlete exception: ${exception.message}")
        }
    }

    override suspend fun fetchFeed() {
        try {
            val fetchedFeed = apiaryService.getFeed().await()
            _fetchedFeed.postValue(fetchedFeed)
        } catch (exception:Exception){
            Timber.d("ApiaryDSImpl fetchFeed exception: ${exception.message}")
        }
    }
}