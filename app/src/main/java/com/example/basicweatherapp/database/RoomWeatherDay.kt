package com.example.basicweatherapp.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WeatherDayDao {
    @Query("SELECT * FROM DatabaseWeatherDay")
    fun getWeatherOfWeek(): LiveData<DatabaseWeatherDay>

    @Query("DELETE FROM DatabaseWeatherDay")
    fun clear()
}

@Database(entities = [DatabaseWeatherDay::class], version = 1)
abstract class WeatherDayDatabase : RoomDatabase() {
    abstract val weatherDayDao: WeatherDayDao
}

private lateinit var INSTANCE: WeatherDayDatabase

fun getDatabaseWeatherDay(context: Context): WeatherDayDatabase {
    synchronized(WeatherDayDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                WeatherDayDatabase::class.java,
                "RoomWeatherDay").build()
        }
    }
    return INSTANCE
}