package ir.jeybar.library.designsystem.primarybutton

import android.animation.Animator
import android.animation.ObjectAnimator
import android.util.Property
import com.turkurt656.library.designsystem.primarybutton.CircularProgressDrawable

internal fun ObjectAnimator.onAnimationRepeat(call: () -> Unit) {
    addListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(p0: Animator?) {}

        override fun onAnimationEnd(p0: Animator?) {}

        override fun onAnimationCancel(p0: Animator?) {}

        override fun onAnimationRepeat(p0: Animator?) { call() }
    })
}

internal fun makeSweepProperty(): Property<CircularProgressDrawable, Float> {
    return object : Property<CircularProgressDrawable, Float>(Float::class.java, "arc") {
        override fun get(p0: CircularProgressDrawable): Float {
            return p0.currentSweepAngle
        }

        override fun set(p0: CircularProgressDrawable, value: Float) {
            p0.currentSweepAngle = value
        }
    }
}

internal fun makeAngleProperty(): Property<CircularProgressDrawable, Float> {
    return object : Property<CircularProgressDrawable, Float>(Float::class.java, "angle") {
        override fun get(p0: CircularProgressDrawable): Float {
            return p0.currentGlobalAngle
        }

        override fun set(p0: CircularProgressDrawable, value: Float) {
            p0.currentGlobalAngle = value
        }
    }
}