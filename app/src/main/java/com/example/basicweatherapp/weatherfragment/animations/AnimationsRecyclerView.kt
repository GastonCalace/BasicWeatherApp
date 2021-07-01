package com.example.basicweatherapp

import android.animation.AnimatorSet
import android.content.Context
import android.widget.FrameLayout
import com.example.basicweatherapp.weatherfragment.animations.newItem
import com.example.basicweatherapp.weatherfragment.animations.positionX
import com.example.basicweatherapp.weatherfragment.animations.positionY

fun clearIcon(context: Context, frameLayout: FrameLayout) {
    val sunBrightness = newItem(context, frameLayout, R.drawable.icon_sun_image, 1f)
    val sunY = positionY(sunBrightness, 10f, 10f)
    val sunX = positionX(sunBrightness, 0f, 0f)

    val set = AnimatorSet()
    set.playTogether(sunY, sunX)
    set.start()
}

fun cloudsIcon(context: Context, frameLayout: FrameLayout) {
    val sunBrightness = newItem(context, frameLayout, R.drawable.icon_sun_image, 1f)
    val sunY = positionY(sunBrightness, 0f, 0f)
    val sunX = positionX(sunBrightness, 30f, 30f)

    val cloud = newItem(context, frameLayout, R.drawable.icon_cloud_image, 1f)
    val cloudY = positionY(cloud, 20f, 20f)
    val cloudX = positionX(cloud, 0f, 00f)

    val set = AnimatorSet()
    set.playTogether(sunY, sunX, cloudY, cloudY)
    set.start()
}

fun rainIcon(context: Context, frameLayout: FrameLayout) {
    val cloud = newItem(context, frameLayout, R.drawable.icon_cloud_image, 1f)
    val cloudY = positionY(cloud, -10f, -10f)
    val cloudX = positionX(cloud, 20f, 20f)

    val rain = newItem(context, frameLayout, R.drawable.icon_rain_image, 1f)
    val rainY = positionY(rain, 20f, 20f)
    val rainX = positionX(rain, 15f, 15f)

    val set = AnimatorSet()
    set.playTogether(cloudY, cloudX, rainY, rainX)
    set.start()
}

fun thunderstormIcon(context: Context, frameLayout: FrameLayout) {
    val cloud = newItem(context, frameLayout, R.drawable.icon_cloud_image, 1f)
    val cloudY = positionY(cloud, -10f, -10f)
    val cloudX = positionX(cloud, 20f, 20f)

    val ray = newItem(context, frameLayout, R.drawable.icon_ray_image, 1f)
    val rayY = positionY(ray, 33f, 33f)
    val rayX = positionX(ray, 25f, 25f)

    val set = AnimatorSet()
    set.playTogether(cloudY, cloudX, rayY, rayX)
    set.start()
}

fun snowIcon(context: Context, frameLayout: FrameLayout) {
    val snowDrop = newItem(context, frameLayout, R.drawable.icon_snow_image, 1f)
    val snowDropY = positionY(snowDrop, 10f, 10f)
    val snowDropX = positionX(snowDrop, 0f, 0f)

    val set = AnimatorSet()
    set.playTogether(snowDropY, snowDropX)
    set.start()
}

fun mistIcon(context: Context, frameLayout: FrameLayout) {
    val mist = newItem(context, frameLayout, R.drawable.icon_mist_image, 1f)
    val mistY = positionY(mist, 10f, 10f)
    val mistX = positionX(mist, 0f, 0f)

    val set = AnimatorSet()
    set.playTogether(mistY, mistX)
    set.start()
}
