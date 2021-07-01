package com.example.basicweatherapp.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DayWeatherDao {
    @Query("SELECT * FROM DatabaseDayWeather ORDER BY dayTime ASC")
    fun getWeatherOfWeek(): LiveData<List<DatabaseDayWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg dayWeather: DatabaseDayWeather)

    @Query("DELETE FROM DatabaseDayWeather")
    fun clear()
}

@Database(entities = [DatabaseDayWeather::class], version = 3)
abstract class DayWeatherDatabase : RoomDatabase() {
    abstract val weatherDayDao: DayWeatherDao
}

private lateinit var INSTANCE: DayWeatherDatabase

fun getDatabaseWeatherDay(context: Context): DayWeatherDatabase {
    synchronized(DayWeatherDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                DayWeatherDatabase::class.java,
                "RoomWeatherDay")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}