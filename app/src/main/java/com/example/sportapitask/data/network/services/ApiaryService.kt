package com.example.sportapitask.data.network.services

import com.example.sportapitask.data.models.NetworkFeedModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiaryService {

    //Since this is mock api where parameters don't change output there is no need to pass arguments
    // into fetchFeed function as result would be the same. In real case scenario function would require as much
    // arguments as needed and they would be map to @Get annotation with @Path or  @Query inside function arugment block
    @GET("/feed")
    fun getFeed():Deferred<NetworkFeedModel>
}