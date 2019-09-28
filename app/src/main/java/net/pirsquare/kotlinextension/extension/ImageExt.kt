package net.pirsquare.kotlinextension.extension

import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView

fun ImageView.animateRotate(from: Float, to: Float, duration: Long = 200) {
    val rotate = RotateAnimation(from, to, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
    rotate.duration = duration
    rotate.fillAfter = true
    this.startAnimation(rotate)
}