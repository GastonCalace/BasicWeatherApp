package com.example.basicweatherapp.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CurrentWeatherDao {
    @Query("SELECT * FROM DatabaseCurrentWeather")
    fun getCurrentWeather(): LiveData<DatabaseCurrentWeather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currentWeather: DatabaseCurrentWeather)

    @Query("DELETE FROM DatabaseCurrentWeather")
    fun clearPastWeather()
}

@Database(entities = [DatabaseCurrentWeather::class], version = 3)
abstract class CurrentWeatherDatabase : RoomDatabase() {
    abstract val currentWeatherDao: CurrentWeatherDao
}

private lateinit var INSTANCE: CurrentWeatherDatabase

fun getDatabaseCurrentWeather(context: Context): CurrentWeatherDatabase {
    synchronized(CurrentWeatherDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
            CurrentWeatherDatabase::class.java,
            "RoomCurrentWeather")
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
    return INSTANCE
}