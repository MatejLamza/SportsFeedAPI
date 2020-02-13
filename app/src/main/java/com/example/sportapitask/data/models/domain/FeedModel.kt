package com.example.sportapitask.data.models.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_FEED_ID = 0

//When using database clean architecture says that we need to use separate model for storing data in DB and seperate model for network data
//Then we should use domain model to display data. That way we wouldn't have unwanted fields in our database and we can store only what
//We need. For this purposes i just need to store 2 things as i already have seperate network model and domain model
@Entity(tableName = "feed")
data class FeedModel(
    var video:VideoModel,
    var description:String
){
    @PrimaryKey(autoGenerate = false)
    var idFeed = CURRENT_FEED_ID
}