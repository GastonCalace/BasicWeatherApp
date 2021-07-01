package com.example.basicweatherapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView

fun clearIcon(context: Context, frameLayout: FrameLayout) {
    val sunBrightness = newItem(context, frameLayout, R.drawable.icon_sun_image, 1f)
    val sunY = moveY(sunBrightness, 10f, 10f)
    val sunX = moveX(sunBrightness, 0f, 0f)

    val set = AnimatorSet()
    set.playTogether(sunY, sunX)
    set.start()
}

fun cloudsIcon(context: Context, frameLayout: FrameLayout) {
    val sunBrightness = newItem(context, frameLayout, R.drawable.icon_sun_image, 1f)
    val sunY = moveY(sunBrightness, 0f, 0f)
    val sunX = moveX(sunBrightness, 30f, 30f)

    val cloud = newItem(context, frameLayout, R.drawable.icon_cloud_image, 1f)
    val cloudY = moveY(cloud, 20f, 20f)
    val cloudX = moveX(cloud, 0f, 00f)

    val set = AnimatorSet()
    set.playTogether(sunY, sunX, cloudY, cloudY)
    set.start()
}

fun rainIcon(context: Context, frameLayout: FrameLayout) {
    val cloud = newItem(context, frameLayout, R.drawable.icon_cloud_image, 1f)
    val cloudY = moveY(cloud, -10f, -10f)
    val cloudX = moveX(cloud, 20f, 20f)

    val rain = newItem(context, frameLayout, R.drawable.icon_rain_image, 1f)
    val rainY = moveY(rain, 20f, 20f)
    val rainX = moveX(rain, 15f, 15f)

    val set = AnimatorSet()
    set.playTogether(cloudY, cloudX, rainY, rainX)
    set.start()
}

fun thunderstormIcon(context: Context, frameLayout: FrameLayout) {
    val cloud = newItem(context, frameLayout, R.drawable.icon_cloud_image, 1f)
    val cloudY = moveY(cloud, -10f, -10f)
    val cloudX = moveX(cloud, 20f, 20f)

    val ray = newItem(context, frameLayout, R.drawable.icon_ray_image, 1f)
    val rayY = moveY(ray, 33f, 33f)
    val rayX = moveX(ray, 25f, 25f)

    val set = AnimatorSet()
    set.playTogether(cloudY, cloudX, rayY, rayX)
    set.start()
}

fun snowIcon(context: Context, frameLayout: FrameLayout) {
    val snowDrop = newItem(context, frameLayout, R.drawable.icon_snow_image, 1f)
    val snowDropY = moveY(snowDrop, 10f, 10f)
    val snowDropX = moveX(snowDrop, 0f, 0f)

    val set = AnimatorSet()
    set.playTogether(snowDropY, snowDropX)
    set.start()
}

fun mistIcon(context: Context, frameLayout: FrameLayout) {
    val mist = newItem(context, frameLayout, R.drawable.icon_mist_image, 1f)
    val mistY = moveY(mist, 10f, 10f)
    val mistX = moveX(mist, 0f, 0f)

    val set = AnimatorSet()
    set.playTogether(mistY, mistX)
    set.start()
}

private fun newItem(context: Context, frameLayout: FrameLayout, image: Int,
                    alpha: Float): AppCompatImageView {
    val newStar = AppCompatImageView(context)
    newStar.alpha = alpha
    newStar.setImageResource(image)
    newStar.layoutParams = FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.WRAP_CONTENT,
        FrameLayout.LayoutParams.WRAP_CONTENT
    )
    frameLayout.addView(newStar)
    return newStar
}

private fun moveX(newStar: AppCompatImageView, start: Float, end: Float): ObjectAnimator? {
    val moverX = ObjectAnimator.ofFloat(
        newStar, View.TRANSLATION_X, start, end)
    return moverX
}

private fun moveY(newStar: AppCompatImageView, start: Float, end: Float): ObjectAnimator? {
    val moverY = ObjectAnimator.ofFloat(
        newStar, View.TRANSLATION_Y, start, end)
    return moverY
}
