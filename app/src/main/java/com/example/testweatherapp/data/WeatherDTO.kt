package com.example.testweatherapp.data

import com.squareup.moshi.Json

data class WeatherDTO (val fact: Fact?)

data class Fact(
    val temp : Double?,
    val condition : String?,
    val icon : String?,
    @Json(name = "wind_speed")val windSpeed : Double?
)