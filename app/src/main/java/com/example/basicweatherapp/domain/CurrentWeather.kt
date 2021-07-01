package com.example.basicweatherapp.domain

import java.util.*


data class CurrentWeather(
        val dayTime: Date,
        val timeZone: String,
        val sunRise: Date,
        val sunSet: Date,
        val temp: Int,
        val feelsLike: Int,
        val weatherId: Int,
        val description: String
)