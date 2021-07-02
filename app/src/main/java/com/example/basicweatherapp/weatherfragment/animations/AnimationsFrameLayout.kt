package com.example.basicweatherapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator.REVERSE
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.basicweatherapp.weatherfragment.animations.*


fun clearDay(context: Context, frameLayout: FrameLayout) {
    val sunBrightness1 = newItem(context, frameLayout, R.drawable.sun_image, .6f)
    val sunY1 = positionY(sunBrightness1, 30f, 30f)
    val sunX1 = positionX(sunBrightness1, 30f, 30f)
    sunBrightness1.scaleX = .8f
    sunBrightness1.scaleY = sunBrightness1.scaleX * 0.9f
    val rotater1 = ObjectAnimator.ofFloat(sunBrightness1, View.ROTATION, -0f, 360f)
    rotater1.duration = 12000L

    val sunBrightness2 = newItem(context, frameLayout, R.drawable.sun_image, .6f)
    val sunY2 = positionY(sunBrightness2, 30f, 30f)
    val sunX2 = positionX(sunBrightness2, 30f, 30f)
    sunBrightness2.scaleX = .9f
    sunBrightness2.scaleY = sunBrightness2.scaleX * 0.9f
    val rotater2 = ObjectAnimator.ofFloat(sunBrightness2, View.ROTATION, -0f, 360f)
    rotater2.duration = 15000L

    val sun = newItem(context, frameLayout, R.drawable.sun_image, 1f)
    val sunY = positionY(sun, 30f, 30f)
    val sunX = positionX(sun, 30f, 30f)
    sun.scaleX = .6f
    sun.scaleY = sun.scaleX

    val set = AnimatorSet()
    set.playTogether(sunY1, sunX1, rotater1, sunY2, sunX2, rotater2, sunY, sunX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_clear)
}

fun clearNight(context: Context, frameLayout: FrameLayout) {
    stars(context, frameLayout)
    val moon = newItem(context, frameLayout, R.drawable.moon_image, 1f)

    moon.scaleX = .8f
    moon.scaleY = moon.scaleX
    val moonY = positionY(moon, 0f, 0f)
    val moonX = positionX(moon, -50f, -50f)

    val set = AnimatorSet()
    set.playTogether(moonY, moonX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_clear_night)
}

fun fewCloudsDay(context: Context, frameLayout: FrameLayout) {
    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.8f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f - Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val sunBrightness = newItem(context, frameLayout, R.drawable.sun_image, 1f)
    val sunY = positionY(sunBrightness, 0f, 0f)
    val sunX = positionX(sunBrightness, 30f, 30f)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.8f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudOneMoveY, cloudOneMoveX, sunY, sunX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_clear)
}

fun fewCloudsNight(context: Context, frameLayout: FrameLayout) {
    stars(context, frameLayout)
    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.8f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f - Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val moon = newItem(context, frameLayout, R.drawable.moon_image, 1f)
    val moonY = positionY(moon, 0f, 0f)
    val moonX = positionX(moon, -50f, -50f)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.8f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudOneMoveY, cloudOneMoveX, moonY, moonX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_clear_night)
}

fun scatteredCloudsDay(context: Context, frameLayout: FrameLayout) {
    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.9f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 500f, 500f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.9f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 200f, 200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.9f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY, cloudTwoMoveX,
        cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_cloudy)
}

fun scatteredCloudsNight(context: Context, frameLayout: FrameLayout) {
    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.9f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 500f, 500f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.9f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 200f, 200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.9f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY, cloudTwoMoveX,
        cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_cloudy_night)
}

fun brokenClouds(context: Context, frameLayout: FrameLayout) {
    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX,
        cloudTwoMoveY, cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy)
}

fun brokenCloudsNight(context: Context, frameLayout: FrameLayout) {
    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX,
        cloudTwoMoveY, cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy_night)
}

fun showerRainDay(context: Context, frameLayout: FrameLayout) {
    rainDrops(context, frameLayout, 1)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX,
        cloudTwoMoveY, cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy)
}

fun showerRainNight(context: Context, frameLayout: FrameLayout) {
    rainDrops(context, frameLayout, 1)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX,
        cloudTwoMoveY, cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy_night)
}

fun rainDay(context: Context, frameLayout: FrameLayout) {
    rainDrops(context, frameLayout, 10)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY,
        cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy)
}

fun rainNight(context: Context, frameLayout: FrameLayout) {
    rainDrops(context, frameLayout, 10)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX,
        cloudTwoMoveY, cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy_night)
}

fun thunderStormDay(context: Context, frameLayout: FrameLayout) {
    rainDrops(context, frameLayout, 10)

    val rayOne = newItem(context, frameLayout, R.drawable.ray_image, 0f)
    rayOne.scaleX = .5f
    rayOne.scaleY = rayOne.scaleX
    val rayOneMoveY = moveY(rayOne, 235f, 225f)
    val rayOneMoveX = positionX(rayOne, 0f, 0f)
    fadeRay(rayOne)

    val rayTwo = newItem(context, frameLayout, R.drawable.ray_image, 0f)
    rayTwo.scaleX = .6f
    rayTwo.scaleY = rayOne.scaleX * 1.2f
    val rayTwoMoveY = moveY(rayTwo, 225f, 235f)
    val rayTwoMoveX = positionX(rayTwo, 350f, 350f)
    fadeRay(rayTwo)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(rayOneMoveY, rayOneMoveX, rayTwoMoveY, rayTwoMoveX,
        cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY,
        cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy)
}

fun thunderStormNight(context: Context, frameLayout: FrameLayout) {
    rainDrops(context, frameLayout, 10)

    val rayOne = newItem(context, frameLayout, R.drawable.ray_image, 0f)
    rayOne.scaleX = .5f
    rayOne.scaleY = rayOne.scaleX
    val rayOneMoveY = moveY(rayOne, 235f, 225f)
    val rayOneMoveX = positionX(rayOne, 0f, 0f)
    fadeRay(rayOne)

    val rayTwo = newItem(context, frameLayout, R.drawable.ray_image, 0f)
    rayTwo.scaleX = .6f
    rayTwo.scaleY = rayOne.scaleX * 1.2f
    val rayTwoMoveY = moveY(rayTwo, 225f, 235f)
    val rayTwoMoveX = positionX(rayTwo, 350f, 350f)
    fadeRay(rayTwo)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(rayOneMoveY, rayOneMoveX, rayTwoMoveY, rayTwoMoveX,
        cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY,
        cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy_night)
}

fun snowDay(context: Context, frameLayout: FrameLayout) {
    snowDrop(context, frameLayout)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY,
        cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy)
}

fun snowNight(context: Context, frameLayout: FrameLayout) {
    snowDrop(context, frameLayout)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = positionY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = positionY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = positionY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = positionY(cloudThree, -20f, -20f)
    val cloudThreeMoveX = moveX(cloudThree, -200f, -200f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 5000L, false)

    val set = AnimatorSet()
    set.playTogether(cloudZeroMoveY, cloudZeroMoveX, cloudOneMoveY, cloudOneMoveX, cloudTwoMoveY,
        cloudTwoMoveX, cloudThreeMoveY, cloudThreeMoveX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy_night)
}

fun mistDay(context: Context, frameLayout: FrameLayout) {
    mist(context, frameLayout)

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy)
}

fun mistNight(context: Context, frameLayout: FrameLayout) {
    mist(context, frameLayout)

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_rainy_night)
}
