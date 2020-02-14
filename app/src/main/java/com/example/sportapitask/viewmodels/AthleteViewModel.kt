package com.example.sportapitask.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapitask.data.models.domain.AthleteModel
import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.utils.NoConnectivityException
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class AthleteViewModel @Inject constructor(val apiaryRepo: ApiaryRepo):ViewModel() {

    var liveAthlete = MutableLiveData<AthleteModel>()
    var liveConnection = MutableLiveData<Boolean>()
    var spinner: MutableLiveData<Boolean> = MutableLiveData()

    fun getAthlete(){
        viewModelScope.launch {
            try {
                spinner.value = true
                liveConnection.value = true
                liveAthlete.value = apiaryRepo.fetchAthlete()
            } catch (exception:NoConnectivityException){
                liveConnection.value = false
                Timber.d("Athlete VM getAthlete message: ${exception.message}")
            } finally {
                spinner.value = false
            }
        }
    }
}