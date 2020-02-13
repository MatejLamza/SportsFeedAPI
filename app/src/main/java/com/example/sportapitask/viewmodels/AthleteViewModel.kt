package com.example.sportapitask.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportapitask.data.models.domain.AthleteModel
import com.example.sportapitask.data.repositories.ApiaryRepo
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class AthleteViewModel @Inject constructor(val apiaryRepo: ApiaryRepo):ViewModel() {

    var liveAthlete = MutableLiveData<AthleteModel>()

    fun getAthlete(){
        viewModelScope.launch {
            try {
                liveAthlete.value = apiaryRepo.fetchAthlete()
            } catch (exception:Exception){
                Timber.d("Athlete VM getAthlete message: ${exception.message}")
            }
        }
    }
}