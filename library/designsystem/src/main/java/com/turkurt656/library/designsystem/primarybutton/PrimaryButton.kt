package com.turkurt656.library.designsystem.primarybutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import com.google.android.material.button.MaterialButton
import com.turkurt656.library.designsystem.R
import com.turkurt656.library.designsystem.ktx.getColorCompat
import com.turkurt656.library.designsystem.ktx.getDimension
import com.turkurt656.library.designsystem.ktx.getDimensionPixelSize
import com.turkurt656.library.designsystem.ktx.orWhite


class PrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.primaryButtonStyle
) : MaterialButton(context, attrs, defStyleAttr) {

    private var progressDrawable: CircularProgressDrawable? = null

    // This is for caching currentTextColor
    // because we are changing textColor to transparent when view is loading
    // and we want to save previous color and revert it when view is not loading
    private var allowCacheColor: Boolean = true
    private var cachedColor: Int = currentTextColor

    var loadingColor: Int = context.getColorCompat(R.color.color_on_primary).orWhite()
        private set

    var loadingWidth: Float = context.getDimension(R.dimen.primary_button_loading_width)
        private set(value) {
            require(value >= 0) { "loadingWidth cannot be less than 0" }
            field = value
        }

    var loadingPadding: Int = context.getDimensionPixelSize(R.dimen.primary_button_loading_padding)
        private set(value) {
            require(value >= 0) { "loadingPadding cannot be less than 0" }
            field = value
        }

    var isLoading = false
        set(value) {
            field = value
            invalidate()
        }

    init {
        //Obtain attrs from xml
        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.PrimaryButton, 0, 0
        )
        typedArray.apply {
            loadingColor =
                getColor(R.styleable.PrimaryButton_loadingColor, loadingColor)
            loadingWidth =
                getDimension(R.styleable.PrimaryButton_loadingWidth, loadingWidth)
            loadingPadding =
                getDimensionPixelSize(
                    R.styleable.PrimaryButton_loadingPadding,
                    loadingPadding
                )
        }
        typedArray.recycle()

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        // We must disable button clicks on loading and disabled status
        return if (!isLoading && isEnabled) super.dispatchTouchEvent(event)
        else false
    }

    override fun setTextColor(colors: ColorStateList?) {
        super.setTextColor(colors)
        if (allowCacheColor) cachedColor = currentTextColor
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
        if (allowCacheColor) cachedColor = currentTextColor
    }

    override fun onDraw(canvas: Canvas?) {
        changeTextColor()
        super.onDraw(canvas)
        handleLoadingDraw(canvas)
    }

    private fun changeTextColor() {
        if (isLoading) {
            allowCacheColor = false
            setTextColor(Color.TRANSPARENT)
        }
        else setTextColor(cachedColor)
        allowCacheColor = true
    }

    private fun handleLoadingDraw(canvas: Canvas?) {
        if (isLoading) {
            drawIndeterminateProgress(canvas)
            invalidate()
        }
    }

    private fun drawIndeterminateProgress(canvas: Canvas?) {
        if (progressDrawable == null) {
            progressDrawable = CircularProgressDrawable(loadingColor, loadingWidth).apply {
                bounds = calculateProgressBounds()
                callback = this@PrimaryButton
            }.also { it.start() }
        } else
            canvas?.let { progressDrawable?.draw(it) }
    }

    private fun calculateProgressBounds(): Rect {
        // Calculate height or width of progress drawable NOTE: height == width
        val l = if (width > height) height - 2 * loadingPadding
        else width - 2 * loadingPadding

        val cx = width / 2
        val cy = height / 2

        val top = cy - l / 2
        val bottom = cy + l / 2
        val left = cx - l / 2
        val right = cx + l / 2

        return Rect(left, top, right, bottom)
    }

}