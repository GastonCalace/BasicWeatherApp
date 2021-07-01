package com.example.basicweatherapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.basicweatherapp.BasicWeatherApp.Companion.prefs
import com.example.basicweatherapp.database.getDatabaseCurrentWeather
import com.example.basicweatherapp.database.getDatabaseWeatherDay
import com.example.basicweatherapp.repository.CurrentWeatherRepository
import com.example.basicweatherapp.repository.DayWeatherRepository
import retrofit2.HttpException


class RefreshDataWorker(appContext: Context, params: WorkerParameters):
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val databaseCurrentWeather = getDatabaseCurrentWeather(applicationContext)
        val repositoryCurrentWeather = CurrentWeatherRepository(databaseCurrentWeather)

        val databaseDayWeather = getDatabaseWeatherDay(applicationContext)
        val repositoryDayWeather = DayWeatherRepository(databaseDayWeather)

        return try {
            repositoryCurrentWeather.refreshCurrentWeather(prefs.getLatitude(), prefs.getLongitude())
            repositoryDayWeather.refreshDaysWeather(prefs.getLatitude(), prefs.getLongitude())
            Result.success()
        } catch (exception: HttpException) {
            Result.retry()
        }
    }
}