package com.example.sportapitask.data.database

import androidx.room.TypeConverter
import com.example.sportapitask.data.models.domain.AthleteModel
import com.example.sportapitask.data.models.domain.CountryModel
import com.example.sportapitask.data.models.domain.SportModel
import com.example.sportapitask.data.models.domain.VideoModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    @TypeConverter
    fun fromVideoModel(video: VideoModel): String?{
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

    @TypeConverter
    fun fromCountryModel(country: CountryModel): String?{
        val gson = Gson()
        val type = object: TypeToken<CountryModel>() {}.type
        return gson.toJson(country,type)
    }

    @TypeConverter
    fun toCountryModel(countryString: String): CountryModel? {
        val gson = Gson()
        val type = object: TypeToken<CountryModel>() {}.type
        return gson.fromJson(countryString,type)
    }

    @TypeConverter
    fun fromSportModel(sport: SportModel): String?{
        val gson = Gson()
        val type = object: TypeToken<SportModel>() {}.type
        return gson.toJson(sport,type)
    }

    @TypeConverter
    fun toSportModel(sportString: String): SportModel? {
        val gson = Gson()
        val type = object: TypeToken<SportModel>() {}.type
        return gson.fromJson(sportString,type)
    }

    @TypeConverter
    fun fromAthleteModel(athleteModel: AthleteModel): String?{
        val gson = Gson()
        val type = object: TypeToken<AthleteModel>() {}.type
        return gson.toJson(athleteModel,type)
    }

    @TypeConverter
    fun toAthleteModel(athleteString: String): AthleteModel? {
        val gson = Gson()
        val type = object: TypeToken<AthleteModel>() {}.type
        return gson.fromJson(athleteString,type)
    }






}