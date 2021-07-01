package com.example.basicweatherapp

import android.widget.FrameLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basicweatherapp.domain.CurrentWeather
import com.example.basicweatherapp.domain.DayWeather
import com.example.basicweatherapp.weatherfragment.WeatherFragmentViewModel
import com.example.basicweatherapp.weatherfragment.WeatherRecyclerViewAdapter
import java.text.DateFormat
import java.util.*

@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(viewModel: WeatherFragmentViewModel?) {
    val adapter = this.adapter as WeatherRecyclerViewAdapter
    adapter.submitList(viewModel?.weeklyWeather?.value)
}

@BindingAdapter("weatherRightNow")
fun FrameLayout.bindFrameLayoutWithAmbient(currentWeather: CurrentWeather?) {
    if (currentWeather != null){
        this.removeAllViews()
        if ((currentWeather.dayTime >= currentWeather.sunRise) && (currentWeather.dayTime < currentWeather.sunSet)) {
            when (currentWeather.weatherId) {
                200, 201, 202, 210, 211, 212, 221, 230, 231, 232 -> thunderStormDay(context, this)
                300, 301, 302, 310, 311, 312, 313, 314, 321 -> showerRainDay(context, this)
                500, 501, 502, 503, 504, 520, 521, 522, 531 -> rainDay(context, this)
                511 , 600, 601, 602, 611, 612, 613, 615, 616, 620, 621, 622 -> snowDay(context, this)
                701, 711, 721, 731, 741, 751, 761, 762, 771, 781 -> mistDay(context, this)
                800 -> clearDay(context, this)
                801 -> fewCloudsDay(context, this)
                802 -> scatteredCloudsDay(context, this)
                803, 804 -> brokenClouds(context, this)
            }
        } else {
            when (currentWeather.weatherId) {
                200, 201, 202, 210, 211, 212, 221, 230, 231, 232 -> thunderStormNight(context, this)
                300, 301, 302, 310, 311, 312, 313, 314, 321 -> showerRainNight(context, this)
                500, 501, 502, 503, 504, 520, 521, 522, 531 -> rainNight(context, this)
                511 , 600, 601, 602, 611, 612, 613, 615, 616, 620, 621, 622 -> snowNight(context, this)
                701, 711, 721, 731, 741, 751, 761, 762, 771, 781 -> mistNight(context, this)
                800 -> clearNight(context, this)
                801 -> fewCloudsNight(context, this)
                802 -> scatteredCloudsNight(context, this)
                803, 804 -> brokenCloudsNight(context, this)
            }
        }
    }
}

@BindingAdapter("location")
fun TextView.bindLocation(timeZone: String?) {
    if (timeZone != null){
        var locationName: String?
        var locationNameUnslashed: String?

        val splitSlashLocation = timeZone.split("/")
        locationNameUnslashed = uniteUnslashedText(splitSlashLocation)

        val splitUnderscoreLocation = locationNameUnslashed?.split("_")
        locationName = uniteUnunderscoredText(splitUnderscoreLocation)
        text = locationName
    }
}

@BindingAdapter("todayDate")
fun TextView.bindTodayDate(date: Date?) {
    if (date != null){
        val formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date)
        text = formattedDate
    }
}

@BindingAdapter("temperatureText")
fun TextView.bindTemperatureText(temp: Int?) {
    text = StringBuilder(temp.toString().plus("°C"))
}

@BindingAdapter("feelsLikeText")
fun TextView.bindFeelsLikeText(feelsLike: Int?) {
    text = StringBuilder("Feels like: ".plus(feelsLike.toString()).plus("°C"))
}


@BindingAdapter("nextDays")
fun FrameLayout.bindDayFrame(main: String?) {
    if (main != null) {
        this.removeAllViews()
        when(main) {
            "Thunderstorm" -> thunderstormIcon(context, this)
            "Drizzle", "Rain" -> rainIcon(context, this)
            "Snow" -> snowIcon(context, this)
            "Mist", "Smoke", "Haze", "Dust", "Fog", "Sand", "Ash", "Squall",
            "Tornado" -> mistIcon(context, this)
            "Clear" -> clearIcon(context, this)
            "Clouds" -> cloudsIcon(context, this)
        }
    }
}

@BindingAdapter("dayOftheWeek")
fun TextView.bindDayOfTheWeek(dayWeather: DayWeather?) {
    if (dayWeather != null){
        val formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(dayWeather.dayTime)
        val splitDate = formattedDate.split(",")
        text = splitDate[0].trim()
    }
}

@BindingAdapter("temperatureMinMaxText")
fun TextView.bindTemperatureMinMaxText(dayWeather: DayWeather?) {
    text = StringBuilder("Min:".plus(dayWeather?.tempMin.toString()).plus("°C / ").plus("Max:").plus(dayWeather?.tempMax.toString()).plus("°C"))
}


private fun uniteUnslashedText(location: List<String>?): String? {
    var nameLocation: String? = null
    for (i in 1 until (location!!.size)) {
        nameLocation = if (location[i] != location.last() ){
            if (nameLocation == null)
                StringBuilder(location[i].trim().plus(",")).toString()
            else
                StringBuilder(nameLocation.plus(location[i].trim()).plus(",")).toString()
        } else {
            if (nameLocation == null)
                StringBuilder(location[i].trim()).toString()
            else
                StringBuilder(nameLocation.plus(location[i].trim())).toString()
        }
    }
    return nameLocation
}

private fun uniteUnunderscoredText(location: List<String>?): String? {
    var nameLocation: String? = null
    for (i in 0 until (location?.size ?: 1)) {
        nameLocation = if (nameLocation == null)
            StringBuilder(location?.get(i)?.trim().plus(" ")).toString()
        else
            StringBuilder(nameLocation.plus(location?.get(i)?.trim()).plus(" ")).toString()
    }
    return nameLocation
}