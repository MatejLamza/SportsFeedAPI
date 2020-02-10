package com.example.sportapitask.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.viewmodels.FeedViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class FeedVMFactory
    @Inject constructor(val apiaryRepo: ApiaryRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FeedViewModel::class.java)){
            return FeedViewModel(apiaryRepo) as T
        } else{
            throw IllegalArgumentException("Unkown class FeedViewModel!")
        }
    }
}