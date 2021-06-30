package com.example.basicweatherapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator.*
import android.content.Context
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout


fun clearDay(context: Context, frameLayout: FrameLayout) {
    val sunBrightness = newItem(context, frameLayout, R.drawable.sun_image, 1f)
    val sunY = moveY(sunBrightness, 30f, 30f)
    val sunX = moveX(sunBrightness, 30f, 30f)

    val set = AnimatorSet()
    set.playTogether(sunY, sunX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_clear)
}

fun clearNight(context: Context, frameLayout: FrameLayout) {
    stars(context, frameLayout)
    val moon = newItem(context, frameLayout, R.drawable.moon_image, 1f)
    moon.scaleX = .8f
    moon.scaleY = moon.scaleX

    val moonY = moveY(moon, 0f, 0f)
    val moonX = moveX(moon, -50f, -50f)

    val set = AnimatorSet()
    set.playTogether(moonY, moonX)
    set.start()

    val background = frameLayout.parent as ConstraintLayout
    background.setBackgroundResource(R.color.color_clear_night)
}

fun fewCloudsDay(context: Context, frameLayout: FrameLayout) {
    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.8f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f - Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val sunBrightness = newItem(context, frameLayout, R.drawable.sun_image, 1f)
    val sunY = moveY(sunBrightness, 0f, 0f)
    val sunX = moveX(sunBrightness, 30f, 30f)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.8f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f - Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val moon = newItem(context, frameLayout, R.drawable.moon_image, 1f)
    val moonY = moveY(moon, 0f, 0f)
    val moonX = moveX(moon, -50f, -50f)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.8f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 500f, 500f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.9f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 200f, 200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.9f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 500f, 500f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.9f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 200f, 200f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.9f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val rayOneMoveX = moveX(rayOne, 0f, 0f)
    fadeRay(rayOne)

    val rayTwo = newItem(context, frameLayout, R.drawable.ray_image, 0f)
    rayTwo.scaleX = .6f
    rayTwo.scaleY = rayOne.scaleX * 1.2f
    val rayTwoMoveY = moveY(rayTwo, 225f, 235f)
    val rayTwoMoveX = moveX(rayTwo, 350f, 350f)
    fadeRay(rayTwo)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val rayOneMoveX = moveX(rayOne, 0f, 0f)
    fadeRay(rayOne)

    val rayTwo = newItem(context, frameLayout, R.drawable.ray_image, 0f)
    rayTwo.scaleX = .6f
    rayTwo.scaleY = rayOne.scaleX * 1.2f
    val rayTwoMoveY = moveY(rayTwo, 225f, 235f)
    val rayTwoMoveX = moveX(rayTwo, 350f, 350f)
    fadeRay(rayTwo)

    val cloudZero = newItem(context, frameLayout, R.drawable.cloud_zero_image, 0.95f)
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
            REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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
    val cloudZeroMoveY = moveY(cloudZero, -80f, -80f)
    val cloudZeroMoveX = moveX(cloudZero, 0f, 0f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 2000L, false)

    val cloudOne = newItem(context, frameLayout, R.drawable.cloud_one_image, 0.95f)
    val cloudOneMoveY = moveY(cloudOne, -40f, -40f)
    val cloudOneMoveX = moveX(cloudOne, 600f, 600f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 4000L, false)

    val cloudTwo = newItem(context, frameLayout, R.drawable.cloud_two_image, 0.95f)
    val cloudTwoMoveY = moveY(cloudTwo, -100f, -100f)
    val cloudTwoMoveX = moveX(cloudTwo, 300f, 300f + Math.random().toFloat() * 200,
        REVERSE, 8000L +  Math.random().toLong() * 3000L, false)

    val cloudThree = newItem(context, frameLayout, R.drawable.cloud_three_image, 0.95f)
    val cloudThreeMoveY = moveY(cloudThree, -20f, -20f)
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

private fun rainDrops(context: Context, frameLayout: FrameLayout, times: Int) {

    repeat(50 * times){
        val newRaindrop = newItem(context, frameLayout, R.drawable.raindrop_image, 0f)

        newRaindrop.scaleX = Math.random().toFloat() * 1.5f + .1f
        newRaindrop.scaleY = newRaindrop.scaleX

        var locationX = Math.random().toFloat() * 800f * 2

        val moverY = moveY(newRaindrop, Math.random().toFloat() * 100 + 300f, 1000f)

        val moverX = moveX(newRaindrop, locationX,  (200f / 2) + locationX)

        val fade = fade(newRaindrop, 150L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

private fun snowDrop(context: Context, frameLayout: FrameLayout) {

    repeat(150){
        val newSnow = newItem(context, frameLayout, R.drawable.snow_image, 0f)

        newSnow.scaleX = Math.random().toFloat() * 2.5f + .1f
        newSnow.scaleY = newSnow.scaleX

        var locationX = Math.random().toFloat() * 1200f

        val moverY = moveY(newSnow, 380f, 1000f)
        val moverX = moveX(newSnow, locationX - Math.random().toFloat() * 400f, locationX )

        val fade = fade(newSnow, 150L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

private fun stars(context: Context, frameLayout: FrameLayout) {

    repeat(25){
        val newStar = newItem(context, frameLayout, R.drawable.star_image, 0f)

        newStar.scaleX = Math.random().toFloat() * 0.5f + .1f
        newStar.scaleY = newStar.scaleX

        var locationY = Math.random().toFloat() * 600f * 2
        var locationX = Math.random().toFloat() * 600f * 2

        val moverY = moveY(newStar, locationY, locationY)

        val moverX = moveX(newStar, locationX, locationX)

        val fade = fade(newStar, 300L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

private fun mist(context: Context, frameLayout: FrameLayout) {

    repeat(35){
        val newDrizzle = newItem(context, frameLayout, R.drawable.drizzle_image, 0f)

        newDrizzle.scaleX = Math.random().toFloat() * 5f + 1f
        newDrizzle.scaleY = newDrizzle.scaleX

        var locationY = Math.random().toFloat() * 1200f
        var locationX = Math.random().toFloat() * 1200f

        val moverY = moveY(newDrizzle, locationY, locationY)

        val moverX = moveX(newDrizzle, locationX, locationX)

        val fade = fade(newDrizzle, 300L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

private fun newItem(context: Context, frameLayout: FrameLayout, image: Int, alpha: Float): AppCompatImageView {
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

private fun fade(newStar: AppCompatImageView, duration: Long, delay: Long = 0L): ObjectAnimator? {
    val fade = ObjectAnimator.ofFloat(newStar, View.ALPHA, 1f)
    fade.duration = duration
    fade.startDelay = Math.random().toLong() * 6000L + delay
    fade.repeatMode = ObjectAnimator.REVERSE
    fade.repeatCount = ObjectAnimator.INFINITE
    return fade
}

private fun moveX(newStar: AppCompatImageView, start: Float, end: Float, mode: Int = RESTART, duration: Long = 0L, acelerate: Boolean = true): ObjectAnimator? {
    val moverX = ObjectAnimator.ofFloat(
            newStar, View.TRANSLATION_X, start, end)
    if (acelerate) moverX.interpolator = AccelerateInterpolator(1f)
    moverX.repeatCount = ObjectAnimator.INFINITE
    moverX.repeatMode = mode
    if (duration != 0L) moverX.duration = duration
    return moverX
}

private fun moveY(newStar: AppCompatImageView, start: Float, end: Float): ObjectAnimator? {
    val moverY = ObjectAnimator.ofFloat(
            newStar, View.TRANSLATION_Y, start, end)
    moverY.interpolator = AccelerateInterpolator(1f)
    moverY.repeatCount = ObjectAnimator.INFINITE
    moverY.repeatMode = ObjectAnimator.RESTART
    return moverY
}

private fun fadeRay(item: AppCompatImageView){

    // Fade the view out to completely transparent and then back to completely opaque

    val animator = ObjectAnimator.ofFloat(item, View.ALPHA, 0.5f)
    animator.duration = 50L * Math.random().toLong() + 80L
    animator.repeatCount = ObjectAnimator.INFINITE
    animator.repeatMode = ObjectAnimator.REVERSE
    animator.start()

}