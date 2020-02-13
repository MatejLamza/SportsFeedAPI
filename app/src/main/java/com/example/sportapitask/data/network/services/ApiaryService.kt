package com.example.sportapitask.data.network.services

import com.example.sportapitask.data.models.NetworkAthleteModel
import com.example.sportapitask.data.models.NetworkFeedModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiaryService {

    //Since this is mock api where parameters don't change output there is no need to pass arguments
    // into fetchFeed function as result would be the same. In real case scenario function would have as much
    // arguments as needed and they would be mapped to @Get annotation with @Path or  @Query inside function arugment block
    @GET("/feed")
    fun getFeed():Deferred<List<NetworkFeedModel>>

    //API GetAllAthletes is not working for some reason so instead this call will just return 1 athlete with id 13
    // in real case scenario this method would return list of athletes and if user wants specific athlete there would be
    // a seperate function that requires Athlete ID which could be passed as argument

    @GET("/athlete/13")
    fun getAthlete():Deferred<NetworkAthleteModel>
}