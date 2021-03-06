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
    val dayTime: Int,
    val timeZoneOffSet: Int,
    val tempMin: Double,
    val tempMax: Double,
    val main: String)


fun DatabaseCurrentWeather.asDomainModel(): CurrentWeather {
    return CurrentWeather(
            dayTime = Date(this.dayTime.toLong()*1000 - this.timeZoneOffSet.toLong()*1000),
            timeZone = this.timeZone,
            sunRise = Date(this.sunRise.toLong()*1000 - this.timeZoneOffSet.toLong()*1000),
            sunSet = Date(this.sunSet.toLong()*1000 - this.timeZoneOffSet.toLong()*1000),
            temp = this.temp.roundToInt(),
            feelsLike = this.feelsLike.roundToInt(),
            weatherId = this.weatherId,
            description = this. description)
}

fun List<DatabaseDayWeather>.asDomainModel(): List<DayWeather> {
    return map {
        DayWeather(
            dayTime = Date(it.dayTime.toLong()*1000 - it.timeZoneOffSet.toLong()*1000),
            tempMin = it.tempMin.roundToInt(),
            tempMax = it.tempMax.roundToInt(),
            main = it.main
        )
    }
}