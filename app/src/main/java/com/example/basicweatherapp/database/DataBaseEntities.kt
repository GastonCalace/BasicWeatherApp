package com.example.basicweatherapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.basicweatherapp.domain.CurrentWeather
import com.example.basicweatherapp.domain.WeatherDay

@Entity
data class DatabaseCurrentWeather constructor(
    @PrimaryKey
    val timeZone: String,
    val temp: Double,
    val main: String)

@Entity
data class DatabaseWeatherDay constructor(
    val tempMin: Double,
    val tempMax: Double,
    val main: String)

fun DatabaseCurrentWeather.asDomainModel(): CurrentWeather {
    return CurrentWeather(
            timeZone = this.timeZone,
            temp = this.temp,
            main = this.main)
}

fun List<DatabaseWeatherDay>.asDomainModel(): List<WeatherDay> {
    return map {
        WeatherDay(
            tempMin = it.tempMin,
            tempMax = it.tempMax,
            main = it.main
        )
    }
}