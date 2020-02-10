package com.example.sportapitask.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.repositories.ApiaryRepo
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class FeedViewModel
@Inject constructor(val apiaryRepo: ApiaryRepo):ViewModel() {

    var liveFeed = MutableLiveData<NetworkFeedModel>()

    fun getFeed(){
        viewModelScope.launch {
            try {
                liveFeed.value = apiaryRepo.fetchFeed().value
            } catch (exception:Exception){
                Timber.d("FeedVM getFeed: ${exception.message}")
            }
        }
    }
}