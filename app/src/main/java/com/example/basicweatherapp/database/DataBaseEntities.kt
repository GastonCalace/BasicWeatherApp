package com.example.basicweatherapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.basicweatherapp.domain.CurrentWeather
import com.example.basicweatherapp.domain.DayWeather

@Entity
data class DatabaseCurrentWeather constructor(
    @PrimaryKey
    val timeZone: String,
    val temp: Double,
    val main: String)

@Entity
data class DatabaseDayWeather constructor(
    @PrimaryKey
    val tempMin: Double,
    val tempMax: Double,
    val main: String)

fun DatabaseCurrentWeather.asDomainModel(): CurrentWeather {
    return CurrentWeather(
            timeZone = this.timeZone,
            temp = this.temp,
            main = this.main)
}

fun List<DatabaseDayWeather>.asDomainModel(): List<DayWeather> {
    return map {
        DayWeather(
            tempMin = it.tempMin,
            tempMax = it.tempMax,
            main = it.main
        )
    }
}