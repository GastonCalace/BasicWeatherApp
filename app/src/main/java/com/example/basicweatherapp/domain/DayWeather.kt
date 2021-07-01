package com.example.basicweatherapp.domain

import java.util.*


data class DayWeather(
    val dayTime: Date,
    val tempMin: Int,
    val tempMax: Int,
    val main: String
)