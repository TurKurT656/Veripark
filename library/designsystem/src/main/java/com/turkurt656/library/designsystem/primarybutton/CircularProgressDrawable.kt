package com.turkurt656.library.designsystem.primarybutton

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.*
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.util.Property
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import ir.jeybar.library.designsystem.primarybutton.makeAngleProperty
import ir.jeybar.library.designsystem.primarybutton.makeSweepProperty
import ir.jeybar.library.designsystem.primarybutton.onAnimationRepeat

internal class CircularProgressDrawable(
    color: Int,
    private val borderWidth: Float
) : Drawable(), Animatable {

    private val bounds = RectF()
    private var modeAppearing = false
    private var running = false

    private val paint: Paint by lazy {
        Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
            this.color = color
        }
    }

    private var currentGlobalAngleOffset = 0f

    var currentGlobalAngle: Float = 0f
        set(value) {
            field = value
            invalidateSelf()
        }

    private val angleProperty: Property<CircularProgressDrawable, Float> = makeAngleProperty()

    private val angleAnimator: ObjectAnimator by lazy {
        ObjectAnimator.ofFloat(this, angleProperty, 360f).apply {
            interpolator = ANGLE_INTERPOLATOR
            duration = ANGLE_ANIMATOR_DURATION.toLong()
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
        }
    }

    var currentSweepAngle: Float = 0f
        set(value) {
            field = value
            invalidateSelf()
        }

    private val sweepProperty: Property<CircularProgressDrawable, Float> = makeSweepProperty()

    private val sweepAnimator: ObjectAnimator by lazy {
        ObjectAnimator.ofFloat(this, sweepProperty, 360f - MIN_SWEEP_ANGLE * 2).apply {
            interpolator = SWEEP_INTERPOLATOR
            duration = SWEEP_ANIMATOR_DURATION.toLong()
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE

            onAnimationRepeat {
                toggleAppearingMode()
            }
        }
    }

    override fun draw(canvas: Canvas) {
        var startAngle = currentGlobalAngle - currentGlobalAngleOffset
        var sweepAngle = currentSweepAngle
        if (!modeAppearing) {
            startAngle += sweepAngle
            sweepAngle = 360 - sweepAngle - MIN_SWEEP_ANGLE
        } else {
            sweepAngle += MIN_SWEEP_ANGLE.toFloat()
        }
        canvas.drawArc(bounds, startAngle, sweepAngle, false, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSPARENT
    }

    override fun isRunning(): Boolean {
        return running
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        this.bounds.left = bounds.left + borderWidth / 2f + .5f
        this.bounds.right = bounds.right - borderWidth / 2f - .5f
        this.bounds.top = bounds.top + borderWidth / 2f + .5f
        this.bounds.bottom = bounds.bottom - borderWidth / 2f - .5f
    }

    override fun start() {
        if (isRunning) return
        running = true
        angleAnimator.start()
        sweepAnimator.start()
        invalidateSelf()
    }

    override fun stop() {
        if (!isRunning) return
        running = false
        angleAnimator.cancel()
        sweepAnimator.cancel()
        invalidateSelf()
    }

    private fun toggleAppearingMode() {
        modeAppearing = !modeAppearing
        if (modeAppearing)
            currentGlobalAngleOffset = (currentGlobalAngleOffset + MIN_SWEEP_ANGLE * 2) % 360
    }

    companion object {
        private val ANGLE_INTERPOLATOR: Interpolator = LinearInterpolator()
        private val SWEEP_INTERPOLATOR: Interpolator = DecelerateInterpolator()
        private const val ANGLE_ANIMATOR_DURATION = 1000
        private const val SWEEP_ANIMATOR_DURATION = 1000
        private const val MIN_SWEEP_ANGLE = 30
    }

}