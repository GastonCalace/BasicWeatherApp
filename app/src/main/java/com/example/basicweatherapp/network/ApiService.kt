package com.example.basicweatherapp.network

import com.example.basicweatherapp.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

interface ApiService {
    @GET("data/2.5/onecall")
    fun getCurrentWeatherAsync(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String = "minutely,hourly,daily,alerts",
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = BuildConfig.ONE_CALL_API_KEY
    ): Deferred<String>

    @GET("data/2.5/onecall")
    fun getForecastAsync(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String = "current,minutely,hourly,alerts",
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = BuildConfig.ONE_CALL_API_KEY
    ): Deferred<String>
}

object WeatherApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val retrofitService = retrofit.create(ApiService::class.java)
}