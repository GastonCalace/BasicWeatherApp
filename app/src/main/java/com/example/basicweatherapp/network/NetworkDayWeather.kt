package com.example.basicweatherapp.network

import com.example.basicweatherapp.database.DatabaseDayWeather
import com.squareup.moshi.Json

data class NetworkDayWeather(
        @Json(name = "temp.min") val tempMin: Double,
        @Json(name = "temp.max") val tempMax: Double,
        @Json(name = "main") val main: String
)

fun List<NetworkDayWeather>.asDatabaseModel(): Array<DatabaseDayWeather> {
        return map {
                DatabaseDayWeather(
                        tempMin = it.tempMin,
                        tempMax = it.tempMax,
                        main = it.main)
        }.toTypedArray()
}