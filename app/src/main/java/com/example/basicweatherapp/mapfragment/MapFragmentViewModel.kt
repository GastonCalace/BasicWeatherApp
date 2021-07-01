package com.example.basicweatherapp.mapfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.basicweatherapp.BasicWeatherApp.Companion.prefs
import com.google.android.gms.maps.model.LatLng

class MapFragmentViewModel(application: Application): AndroidViewModel(application){

    private val location = LatLng(prefs.getLatitude(), prefs.getLongitude())

    fun getLocation(): LatLng {
        return location
    }

    fun selectLocation(locationSelected: LatLng?) {
        if (locationSelected != null){
            prefs.setLatitude(locationSelected.latitude)
            prefs.setLongitude(locationSelected.longitude)
        }
    }

}