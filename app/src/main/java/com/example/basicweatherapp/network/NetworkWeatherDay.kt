package com.example.basicweatherapp.network

import com.example.basicweatherapp.database.DatabaseWeatherDay
import com.squareup.moshi.Json

data class NetworkWeatherDay(
        @Json(name = "temp.min") val tempMin: Double,
        @Json(name = "temp.max") val tempMax: Double,
        @Json(name = "main") val main: String
)

fun List<NetworkWeatherDay>.asDatabaseModel(): Array<DatabaseWeatherDay> {
        return map {
                DatabaseWeatherDay(
                        tempMin = it.tempMin,
                        tempMax = it.tempMax,
                        main = it.main)
        }.toTypedArray()
}