package com.example.basicweatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.basicweatherapp.database.CurrentWeatherDatabase
import com.example.basicweatherapp.database.asDomainModel
import com.example.basicweatherapp.domain.CurrentWeather
import com.example.basicweatherapp.network.WeatherApi
import com.example.basicweatherapp.network.asDatabaseModel
import com.example.basicweatherapp.network.parseCurrentWeatherJsonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class CurrentWeatherRepository(private val database: CurrentWeatherDatabase) {

    val currentWeather: LiveData<CurrentWeather> = Transformations.map(database.currentWeatherDao.getCurrentWeather()) {
        it?.asDomainModel()
    }

    suspend fun refreshCurrentWeather(lat: Double, lon: Double) {
        withContext(Dispatchers.IO) {
            val currentWeather = WeatherApi.retrofitService.getCurrentWeatherAsync(lat.toString(),lon.toString())
               .await()
            database.currentWeatherDao.clearPastWeather()
            database.currentWeatherDao.insert(parseCurrentWeatherJsonResult(
                JSONObject(currentWeather))
                .asDatabaseModel())
        }
    }
}