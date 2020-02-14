package com.example.sportapitask.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapitask.data.models.domain.FeedModel
import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.utils.NoConnectivityException
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class FeedViewModel
@Inject constructor(val apiaryRepo: ApiaryRepo):ViewModel() {

    var liveFeed = MutableLiveData<List<FeedModel>>()
    var liveConnection = MutableLiveData<Boolean>()
    var spinner: MutableLiveData<Boolean> = MutableLiveData()

    fun getFeed(){
        viewModelScope.launch {
            try {
                spinner.value = true
                liveConnection.value = true
                liveFeed.value = apiaryRepo.fetchFeed()
            } catch (exception:NoConnectivityException){
                liveConnection.value = false
                Timber.d("FeedVM getFeed: ${exception.message}")
            } finally {
                spinner.value = false
            }
        }
    }
}