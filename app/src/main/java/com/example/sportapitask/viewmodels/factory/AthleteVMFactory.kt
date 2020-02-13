package com.example.sportapitask.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.viewmodels.AthleteViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class AthleteVMFactory @Inject constructor(val apiaryRepo: ApiaryRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AthleteViewModel::class.java)){
            return AthleteViewModel(apiaryRepo) as T
        } else{
            throw IllegalArgumentException("Unkown Class AthleteViewModel!")
        }
    }
}