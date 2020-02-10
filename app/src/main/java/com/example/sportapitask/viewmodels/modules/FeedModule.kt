package com.example.sportapitask.viewmodels.modules

import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.viewmodels.factory.FeedVMFactory
import dagger.Module
import dagger.Provides

@Module
class FeedModule {
    @Provides
    fun provideFeedVMFactory(apiaryRepo: ApiaryRepo):FeedVMFactory{
        return FeedVMFactory(apiaryRepo)
    }
}