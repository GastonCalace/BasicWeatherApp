package com.example.basicweatherapp.domain

import java.util.*


data class CurrentWeather(
        val dayTime: Date,
        val timeZone: String,
        val sunRise: Date,
        val sunSet: Date,
        val temp: Double,
        val feelsLike: Double,
        val weatherId: Int,
        val description: String
)