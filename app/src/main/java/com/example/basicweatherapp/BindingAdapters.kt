package com.example.basicweatherapp

import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basicweatherapp.domain.CurrentWeather
import com.example.basicweatherapp.weatherfragment.WeatherFragmentViewModel
import com.example.basicweatherapp.weatherfragment.WeatherRecyclerViewAdapter

@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(viewModel: WeatherFragmentViewModel?) {
    val adapter = this.adapter as WeatherRecyclerViewAdapter
    adapter.submitList(viewModel?.weeklyWeather?.value)
}

@BindingAdapter("weatherRightNow")
fun FrameLayout.bindFrameLayout(currentWeather: CurrentWeather?) {
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



















//@BindingAdapter("sunBinder")
//fun ImageView.bindSun(currentWeather: CurrentWeather?) {
//    if (currentWeather?.main == "Clear") {
//        this.isVisible = true
//        this.rotater()
//    } else {
//        this.isGone = true
//    }
//}
//
//@BindingAdapter("cloudBinder")
//fun ImageView.bindCloud(currentWeather: CurrentWeather?) {
//    this.translater(Math.random().toFloat() * 150, 5000L)
//    when(currentWeather?.main) {
//        "Clouds" -> {
//            this.isVisible = true
//            this.alpha = 0.8F
//        }
//        "Rain" -> {
//            this.isVisible = true
//            this.alpha = 0.95F
//        }
//        "Thunderstorm"-> this.isVisible = true
//        "Snow" -> this.isVisible = true
//        else -> this.isGone = true
//    }
//}
//
//@BindingAdapter("rainSnow")
//fun FrameLayout.bindRainSnow(currentWeather: CurrentWeather?) {
//    when(currentWeather?.main) {
//        "Rain" -> { rain(this.context, this, 1) }
//        "Thunderstorm" -> { rain(this.context, this, 3) }
//        "Snow" -> { snow(this.context, this)}
//        else -> drizzle(this.context, this)
//    }
//}
//
//@BindingAdapter("rayBinder")
//fun ImageView.bindRay(currentWeather: CurrentWeather?) {
//    if (currentWeather?.main == "Thunderstorm") {
//        this.isVisible = true
//        this.fader()
//    } else {
//        this.isGone = true
//    }
//}