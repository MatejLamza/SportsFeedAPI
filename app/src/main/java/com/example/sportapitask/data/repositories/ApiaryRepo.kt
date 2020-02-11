package com.example.sportapitask.data.repositories


import com.example.sportapitask.data.models.domain.FeedModel

interface ApiaryRepo {

    //Network
    suspend fun fetchFeed(): List<FeedModel>
}