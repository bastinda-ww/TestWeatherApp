package com.example.testweatherapp.network

import com.example.testweatherapp.data.IpDTO
import com.example.testweatherapp.data.WeatherDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://ip-api.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface IpApiService{
    @GET("json")
    suspend fun getCurrentLocation(
        @Query("fields") fields: String = "status,country,city,lat,lon,query"
    ): IpDTO
}

object IpApi {
    val retrofitService : IpApiService by lazy {
        retrofit.create(IpApiService::class.java) }
}