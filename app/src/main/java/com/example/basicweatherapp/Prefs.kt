package com.example.basicweatherapp

import android.content.Context

class Prefs(val context: Context) {

    private val SHARED_NAME = "MyDatabase"
    private val LATITUDE = "Latitude"
    private val LONGITUDE = "Longitude"
    private val KM_0_LATITUDE = "-34.905896"
    private val KM_0_LONGITUDE = "-56.191373"

    private val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun setLatitude(latitude: Double) {
        storage.edit().putString(LATITUDE, latitude.toString()).apply()
    }

    fun setLongitude(longitude: Double) {
        storage.edit().putString(LONGITUDE, longitude.toString()).apply()
    }

    fun getLatitude(): Double {
        return storage.getString(LATITUDE, KM_0_LATITUDE)!!.toDouble()
    }

    fun getLongitude(): Double {
        return storage.getString(LONGITUDE, KM_0_LONGITUDE)!!.toDouble()
    }
}