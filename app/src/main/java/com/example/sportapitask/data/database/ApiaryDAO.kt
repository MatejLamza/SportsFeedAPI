package com.example.sportapitask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sportapitask.data.models.domain.CURRENT_FEED_ID
import com.example.sportapitask.data.models.domain.FeedModel

@Dao
interface ApiaryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertFeed(feedModel: List<FeedModel>)

    @Query("SELECT * FROM feed WHERE idFeed = $CURRENT_FEED_ID")
    fun getFeedFromCache():List<FeedModel>
}