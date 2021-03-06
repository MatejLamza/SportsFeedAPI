package com.example.sportapitask.dependency

import android.content.Context
import androidx.room.Room
import com.example.sportapitask.base.BaseApp
import com.example.sportapitask.data.database.ApiaryDAO
import com.example.sportapitask.data.database.ApiaryDatabase
import com.example.sportapitask.data.network.ApiaryDataSource
import com.example.sportapitask.data.network.ApiaryDataSourceImpl
import com.example.sportapitask.data.network.services.ApiaryService
import com.example.sportapitask.data.repositories.ApiaryRepo
import com.example.sportapitask.data.repositories.ApiaryRepoImpl
import com.example.sportapitask.internal.ConnectivityDetection
import com.example.sportapitask.internal.ConnectivityDetectionImpl
import com.example.sportapitask.utils.MyConsts
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
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
    fun provideApiaryService(interceptor:ConnectivityDetection):ApiaryService{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(MyConsts.APIARY_BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiaryService::class.java)
    }

    @Provides
    @Singleton
    fun provideConnectivityDetection(conDetectionImpl: ConnectivityDetectionImpl): ConnectivityDetection {
        return conDetectionImpl
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

    @Provides
    @Singleton
    fun provideApiaryDB(context: Context):ApiaryDatabase{
        return Room.databaseBuilder(
            context,
            ApiaryDatabase::class.java,
            MyConsts.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideApiaryDAO(db:ApiaryDatabase):ApiaryDAO{
        return db.getApiaryDAO()
    }
}