package com.example.basicweatherapp.domain


data class CurrentWeather(
        val timeZone: String,
        val temp: Double,
        val main: String
)