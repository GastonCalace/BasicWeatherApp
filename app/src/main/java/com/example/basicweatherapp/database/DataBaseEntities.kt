package com.example.basicweatherapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.basicweatherapp.domain.CurrentWeather
import com.example.basicweatherapp.domain.DayWeather
import java.util.*
import kotlin.math.roundToInt

@Entity
data class DatabaseCurrentWeather constructor(
    @PrimaryKey
    val dayTime: Int,
    val timeZone: String,
    val timeZoneOffSet: Int,
    val sunRise: Int,
    val sunSet: Int,
    val temp: Double,
    val feelsLike: Double,
    val weatherId: Int,
    val description: String)

@Entity
data class DatabaseDayWeather constructor(
    @PrimaryKey
    val tempMin: Double,
    val tempMax: Double,
    val main: String)


fun DatabaseCurrentWeather.asDomainModel(): CurrentWeather {
    return CurrentWeather(
            dayTime = Date(this.dayTime.toLong()*1000 - this.timeZoneOffSet.toLong()*1000),
            timeZone = this.timeZone,
            sunRise = Date(this.sunRise.toLong()*1000 - this.timeZoneOffSet.toLong()*1000),
            sunSet = Date(this.sunSet.toLong()*1000 - this.timeZoneOffSet.toLong()*1000),
            temp = this.temp,
            feelsLike = this.feelsLike,
            weatherId = this.weatherId,
            description = this. description)
}

fun List<DatabaseDayWeather>.asDomainModel(): List<DayWeather> {
    return map {
        DayWeather(
            tempMin = it.tempMin.roundToInt().toString(),
            tempMax = it.tempMax.roundToInt().toString(),
            main = it.main
        )
    }
}