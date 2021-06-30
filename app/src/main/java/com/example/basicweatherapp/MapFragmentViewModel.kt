package com.example.basicweatherapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.basicweatherapp.BasicWeatherApp.Companion.prefs
import com.google.android.gms.maps.model.LatLng

class MapFragmentViewModel(application: Application): AndroidViewModel(application){

    private val locationLatitude = prefs.getLatitude()
    private val locationLongitude = prefs.getLongitude()

    fun getLocation(): LatLng {
        return LatLng(locationLatitude, locationLongitude)
    }

    fun selectLocation(locationSelected: LatLng?) {
        if (locationSelected != null){
            prefs.setLatitude(locationSelected!!.latitude)
            prefs.setLongitude(locationSelected!!.longitude)
        }
    }

}