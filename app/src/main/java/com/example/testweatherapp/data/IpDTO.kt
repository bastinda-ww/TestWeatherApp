package com.example.testweatherapp.data

data class IpDTO(
    val status : String?,
    val country : String?,
    val city : String?,
    val lat : Double?,
    val lon : Double?,
    val query : String?
)