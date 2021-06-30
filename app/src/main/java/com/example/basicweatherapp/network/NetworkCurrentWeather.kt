package com.example.basicweatherapp.network

import com.example.basicweatherapp.database.DatabaseCurrentWeather

data class NetworkCurrentWeather(
        val dayTime: Int,
        val timeZone: String,
        val timeZoneOffSet: Int,
        val sunRise: Int,
        val sunSet: Int,
        val temp: Double,
        val feelsLike: Double,
        val weatherId: Int,
        val description: String)

fun NetworkCurrentWeather.asDatabaseModel(): DatabaseCurrentWeather {
        return DatabaseCurrentWeather(
                dayTime = this.dayTime,
                timeZone = this.timeZone,
                timeZoneOffSet = this.timeZoneOffSet,
                sunRise = this.sunRise,
                sunSet = this.sunSet,
                temp = this.temp,
                feelsLike = this.feelsLike,
                weatherId = this.weatherId,
                description = this. description)
}