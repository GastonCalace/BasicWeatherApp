package com.example.basicweatherapp.network


import org.json.JSONObject

fun parseDayWeatherJsonResult(jsonResult: JSONObject): ArrayList<NetworkDayWeather> {

    val dailyObjectsJson = jsonResult.getJSONArray("daily")
    val dayWeatherList = ArrayList<NetworkDayWeather>()

    for (i in 1 until dailyObjectsJson.length()) {
        val dailyJson = dailyObjectsJson.getJSONObject(i)

        val dayTime = dailyJson.getInt("dt")
        val timeZoneOffSet = jsonResult.getInt("timezone_offset")
        val tempMin = dailyJson.getJSONObject("temp").getDouble("min")
        val tempMax = dailyJson.getJSONObject("temp").getDouble("max")
        val main = dailyJson.getJSONArray("weather").getJSONObject(0).getString("main")

        val networkDayWeather = NetworkDayWeather(dayTime, timeZoneOffSet, tempMin, tempMax, main)
        dayWeatherList.add(networkDayWeather)

    }

    return dayWeatherList
}

fun parseCurrentWeatherJsonResult(jsonResult: JSONObject): NetworkCurrentWeather {

    val currentJson = jsonResult.getJSONObject("current")

    val dayTime = currentJson.getInt("dt")
    val timeZone = jsonResult.getString("timezone")
    val timeZoneOffSet = jsonResult.getInt("timezone_offset")
    val sunSet = currentJson.getInt("sunset")
    val sunRise = currentJson.getInt("sunrise")
    val temp = currentJson.getDouble("temp")
    val feelsLike = currentJson.getDouble("feels_like")
    val weatherId = currentJson.getJSONArray("weather").getJSONObject(0).getInt("id")
    val description = currentJson.getJSONArray("weather").getJSONObject(0).getString("main")

    return NetworkCurrentWeather(dayTime, timeZone, timeZoneOffSet, sunRise, sunSet, temp, feelsLike, weatherId, description)
}