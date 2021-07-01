package com.example.basicweatherapp.weatherfragment.animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.example.basicweatherapp.R

internal fun rainDrops(context: Context, frameLayout: FrameLayout, times: Int) {

    repeat(50 * times){
        val newRaindrop = newItem(context, frameLayout, R.drawable.raindrop_image, 0f)

        newRaindrop.scaleX = Math.random().toFloat() * 1.5f + .1f
        newRaindrop.scaleY = newRaindrop.scaleX

        var locationX = Math.random().toFloat() * 800f * 2

        val moverY = moveY(newRaindrop, Math.random().toFloat() * 100 + 300f, 1000f)
        val moverX = moveX(newRaindrop, locationX,  100f + locationX)
        val fade = fade(newRaindrop, 150L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

internal fun snowDrop(context: Context, frameLayout: FrameLayout) {

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

internal fun stars(context: Context, frameLayout: FrameLayout) {

    repeat(25){
        val newStar = newItem(context, frameLayout, R.drawable.star_image, 0f)

        newStar.scaleX = Math.random().toFloat() * 0.5f + .1f
        newStar.scaleY = newStar.scaleX

        var locationY = Math.random().toFloat() * 600f * 2
        var locationX = Math.random().toFloat() * 600f * 2

        val moverY = positionY(newStar, locationY, locationY)
        val moverX = positionX(newStar, locationX, locationX)
        val fade = fade(newStar, 300L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

internal fun mist(context: Context, frameLayout: FrameLayout) {

    repeat(35){
        val newDrizzle = newItem(context, frameLayout, R.drawable.drizzle_image, 0f)

        newDrizzle.scaleX = Math.random().toFloat() * 5f + 1f
        newDrizzle.scaleY = newDrizzle.scaleX

        var locationY = Math.random().toFloat() * 1200f
        var locationX = Math.random().toFloat() * 1200f

        val moverY = positionY(newDrizzle, locationY, locationY)
        val moverX = positionX(newDrizzle, locationX, locationX)
        val fade = fade(newDrizzle, 300L)

        val set = AnimatorSet()
        set.playTogether(moverY, moverX, fade)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.start()
    }
}

//Crates a new Item with image selected into the FrameLayout
internal fun newItem(context: Context, frameLayout: FrameLayout, image: Int,
                    alpha: Float): AppCompatImageView {
    val item = AppCompatImageView(context)
    item.alpha = alpha
    item.setImageResource(image)
    item.layoutParams = FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.WRAP_CONTENT,
        FrameLayout.LayoutParams.WRAP_CONTENT
    )
    frameLayout.addView(item)
    return item
}

//Fade effect
internal fun fade(newStar: AppCompatImageView, duration: Long, delay: Long = 0L): ObjectAnimator? {
    val fade = ObjectAnimator.ofFloat(newStar, View.ALPHA, 1f)
    fade.duration = duration
    fade.startDelay = Math.random().toLong() * 6000L + delay
    fade.repeatMode = ObjectAnimator.REVERSE
    fade.repeatCount = ObjectAnimator.INFINITE
    return fade
}

//Sets item in X cardinals
internal fun positionX(item: AppCompatImageView, start: Float, end: Float, mode: Int = ValueAnimator.RESTART): ObjectAnimator? {
    return ObjectAnimator.ofFloat(
        item, View.TRANSLATION_X, start, end)
}

//Sets item in Y cardinals
internal fun positionY(item: AppCompatImageView, start: Float, end: Float): ObjectAnimator? {
    return ObjectAnimator.ofFloat(
        item, View.TRANSLATION_Y, start, end)
}


//Movement of an item in X cardinals
internal fun moveX(item: AppCompatImageView, start: Float, end: Float, mode: Int = ValueAnimator.RESTART,
                  duration: Long = 0L, acelerate: Boolean = true): ObjectAnimator? {
    val moverX = ObjectAnimator.ofFloat(
        item, View.TRANSLATION_X, start, end)
    if (acelerate) moverX.interpolator = AccelerateInterpolator(1f)
    moverX.repeatCount = ObjectAnimator.INFINITE
    moverX.repeatMode = mode
    if (duration != 0L) moverX.duration = duration
    return moverX
}

//Movement of an item in Y cardinals
internal fun moveY(item: AppCompatImageView, start: Float, end: Float): ObjectAnimator? {
    val moverY = ObjectAnimator.ofFloat(
        item, View.TRANSLATION_Y, start, end)
    moverY.interpolator = AccelerateInterpolator(1f)
    moverY.repeatCount = ObjectAnimator.INFINITE
    moverY.repeatMode = ObjectAnimator.RESTART
    return moverY
}

//Fade in - fade out a ray
internal fun fadeRay(item: AppCompatImageView){

    val animator = ObjectAnimator.ofFloat(item, View.ALPHA, 0.5f)
    animator.duration = 50L * Math.random().toLong() + 80L
    animator.repeatCount = ObjectAnimator.INFINITE
    animator.repeatMode = ObjectAnimator.REVERSE
    animator.start()

}