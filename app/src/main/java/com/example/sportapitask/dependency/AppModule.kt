package com.example.sportapitask.dependency

import android.content.Context
import com.example.sportapitask.base.BaseApp
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.models.domain.FeedModel
import com.example.sportapitask.data.network.ApiaryDataSource
import com.example.sportapitask.data.network.ApiaryDataSourceImpl
import com.example.sportapitask.data.network.services.ApiaryService
import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.data.repositories.ApiaryRepoImpl
import com.example.sportapitask.internal.ListMapper
import com.example.sportapitask.internal.Mapper
import com.example.sportapitask.utils.MyConsts
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: BaseApp): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideApiaryService():ApiaryService{
        return Retrofit.Builder()
            .baseUrl(MyConsts.APIARY_BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiaryService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiaryDataSource(apiaryDSImpl:ApiaryDataSourceImpl):ApiaryDataSource{
        return apiaryDSImpl
    }

    @Singleton
    @Provides
    fun provideApiaryRepo(apiaryRepoImpl: ApiaryRepoImpl):ApiaryRepo{
        return apiaryRepoImpl
    }
}