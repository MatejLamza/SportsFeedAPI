package com.example.sportapitask.data.models.domain

data class AthleteModel(
    var age:Int,
    var avatar:String,
    var club:String,
    var country:CountryModel,
    var name:String,
    var sport:SportModel
)