package com.example.sportapitask.viewmodels.modules

import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.viewmodels.factory.AthleteVMFactory
import dagger.Module
import dagger.Provides

@Module
class AthleteModule {
    @Provides
    fun provideAthleteVMFactory(apiaryRepo: ApiaryRepo):AthleteVMFactory{
        return AthleteVMFactory(apiaryRepo)
    }
}