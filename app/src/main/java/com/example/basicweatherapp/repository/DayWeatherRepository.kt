package com.example.basicweatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.basicweatherapp.database.DayWeatherDatabase
import com.example.basicweatherapp.database.asDomainModel
import com.example.basicweatherapp.domain.DayWeather
import com.example.basicweatherapp.network.WeatherApi
import com.example.basicweatherapp.network.asDatabaseModel
import com.example.basicweatherapp.network.parseDayWeatherJsonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class DayWeatherRepository(private val database: DayWeatherDatabase) {

    val dayWeather: LiveData<List<DayWeather>> = Transformations.map(database.weatherDayDao.getWeatherOfWeek()) {
        it.asDomainModel()
    }

    suspend fun refreshDaysWeather(lat: Double, lon: Double) {
        withContext(Dispatchers.IO) {
            val dayWeatherList = WeatherApi.retrofitService.getForecastAsync(lat.toString(),lon.toString()).await()
            database.weatherDayDao.clear()
            database.weatherDayDao.insertAll(*parseDayWeatherJsonResult(
                JSONObject(dayWeatherList))
                .asDatabaseModel())
        }
    }

    fun getDayWeatherList(): LiveData<List<DayWeather>> {
        return Transformations.map(database.weatherDayDao.getWeatherOfWeek()) {
            it.asDomainModel()
        }
    }
}