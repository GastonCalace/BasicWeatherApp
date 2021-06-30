package com.example.basicweatherapp.network

import com.example.basicweatherapp.database.DatabaseDayWeather
import com.squareup.moshi.Json

data class NetworkDayWeather(
        val tempMin: Double,
        val tempMax: Double,
        val main: String
)

fun List<NetworkDayWeather>.asDatabaseModel(): Array<DatabaseDayWeather> {
        return map {
                DatabaseDayWeather(
                        tempMin = it.tempMin,
                        tempMax = it.tempMax,
                        main = it.main)
        }.toTypedArray()
}