package com.example.sportapitask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sportapitask.data.models.domain.FeedModel

@Database(entities = arrayOf(FeedModel::class),version = 1)
@TypeConverters(TypeConverter::class)
abstract class ApiaryDatabase:RoomDatabase() {
    abstract fun getApiaryDAO():ApiaryDAO
}