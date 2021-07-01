package com.example.basicweatherapp.weatherfragment

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicweatherapp.BasicWeatherApp.Companion.prefs
import com.example.basicweatherapp.database.getDatabaseCurrentWeather
import com.example.basicweatherapp.database.getDatabaseWeatherDay
import com.example.basicweatherapp.repository.CurrentWeatherRepository
import com.example.basicweatherapp.repository.DayWeatherRepository
import kotlinx.coroutines.launch


class WeatherFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val databaseCurrentWeather = getDatabaseCurrentWeather(application)
    private val currentWeatherRepository = CurrentWeatherRepository(databaseCurrentWeather)

    private val databaseDayWeather = getDatabaseWeatherDay(application)
    private val dayWeatherRepository = DayWeatherRepository(databaseDayWeather)

    private val locationLatitude = prefs.getLatitude()
    private val locationLongitude = prefs.getLongitude()

    init {
        viewModelScope.launch {
            if (isNetworkAvailable(application)) {
                currentWeatherRepository.refreshCurrentWeather(locationLatitude, locationLongitude)
                dayWeatherRepository.refreshDaysWeather(locationLatitude, locationLongitude)
            }
        }
    }

    var currentWeather = currentWeatherRepository.currentWeather
    var weeklyWeather = dayWeatherRepository.dayWeather

    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        }
        return false
    }
}