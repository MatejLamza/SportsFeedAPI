package com.example.sportapitask.data.database

import androidx.room.TypeConverter
import com.example.sportapitask.data.models.domain.VideoModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    @TypeConverter
    fun fromVideModel(video: VideoModel): String?{
        val gson = Gson()
        val type = object: TypeToken<VideoModel>() {}.type
        return gson.toJson(video,type)
    }

    @TypeConverter
    fun toVideoModel(videoString: String): VideoModel? {
        val gson = Gson()
        val type = object: TypeToken<VideoModel>() {}.type
        return gson.fromJson(videoString,type)
    }
}