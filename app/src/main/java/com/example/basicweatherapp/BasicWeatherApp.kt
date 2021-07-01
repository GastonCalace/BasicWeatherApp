package com.example.basicweatherapp

import android.app.Application

class BasicWeatherApp: Application() {

    companion object{
        //Global reference
        lateinit var prefs:Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}