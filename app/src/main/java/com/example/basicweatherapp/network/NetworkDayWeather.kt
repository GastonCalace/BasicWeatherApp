package com.example.basicweatherapp.network

import com.example.basicweatherapp.database.DatabaseDayWeather

data class NetworkDayWeather(
        val dayTime: Int,
        val timeZoneOffSet: Int,
        val tempMin: Double,
        val tempMax: Double,
        val main: String
)

fun List<NetworkDayWeather>.asDatabaseModel(): Array<DatabaseDayWeather> {
        return map {
                DatabaseDayWeather(
                        dayTime = it.dayTime,
                        timeZoneOffSet = it.timeZoneOffSet,
                        tempMin = it.tempMin,
                        tempMax = it.tempMax,
                        main = it.main)
        }.toTypedArray()
}