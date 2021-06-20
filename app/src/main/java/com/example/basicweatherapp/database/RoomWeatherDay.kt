package com.example.basicweatherapp.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DayWeatherDao {
    @Query("SELECT * FROM DatabaseDayWeather")
    fun getWeatherOfWeek(): LiveData<DatabaseDayWeather>

    @Query("DELETE FROM DatabaseDayWeather")
    fun clear()
}

@Database(entities = [DatabaseDayWeather::class], version = 1)
abstract class DayWeatherDatabase : RoomDatabase() {
    abstract val weatherDayDao: DayWeatherDao
}

private lateinit var INSTANCE: DayWeatherDatabase

fun getDatabaseWeatherDay(context: Context): DayWeatherDatabase {
    synchronized(DayWeatherDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                DayWeatherDatabase::class.java,
                "RoomWeatherDay").build()
        }
    }
    return INSTANCE
}