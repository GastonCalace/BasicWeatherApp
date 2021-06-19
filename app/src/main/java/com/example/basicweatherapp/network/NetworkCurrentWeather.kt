package com.example.basicweatherapp.network

import com.example.basicweatherapp.database.DatabaseCurrentWeather
import com.squareup.moshi.Json

data class NetworkCurrentWeather(
        @Json(name = "timezone") val timeZone: String,
        val temp: Double,
        val main: String
)

fun NetworkCurrentWeather.asDatabaseModel(): DatabaseCurrentWeather {
        return DatabaseCurrentWeather(
                timeZone = this.timeZone,
                temp = this.temp,
                main = this.main)
}