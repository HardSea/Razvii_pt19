package com.pmacademy.razvii_pt19

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class PowerSwitcherImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : AppCompatImageView(context, attributeSet) {

    private val paint = Paint()
    private var size = 0

    private var currentPower = 0
        set(state) {
            field = if (state >= 4 || state < 0) {
                0
            } else {
                state
            }
            invalidate()
        }

    init {
        paint.isAntiAlias = true
        setupAttributes(attributeSet)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.PowerSwitcherImageView,
            0, 0
        )

        val power = typedArray.getInt(R.styleable.PowerSwitcherImageView_power, currentPower)
        currentPower = power

        typedArray.recycle()
    }

    fun changeSpeedFan() {
        currentPower++
    }

    override fun onDraw(canvas: Canvas) {
        drawNumbers(canvas)
        drawBackground(canvas)
        drawDots(canvas)
        super.onDraw(canvas)
    }

    private fun drawDots(canvas: Canvas) {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL

        val radius = size / 30f

        var x = 0f
        var y = 0f
        when (currentPower) {
            0 -> {
                x = size * 0.2f
                y = size * 0.3f
            }
            1 -> {
                x = size * 0.33f
                y = size * 0.18f
            }
            2 -> {
                x = size * 0.52f
                y = size * 0.135f

            }
            3 -> {
                x = size * 0.7f
                y = size * 0.19f
            }
        }
        canvas.drawCircle(x, y, radius, paint)
    }

    private fun drawNumbers(canvas: Canvas) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawPaint(paint)

        paint.color = Color.BLACK
        paint.textSize = size / 15f

        val xFirstNumber = size * 0.1
        val yFirstNumber = size * 0.28
        canvas.drawText("0", xFirstNumber.toFloat(), yFirstNumber.toFloat(), paint)

        val xSecondNumber = size * 0.28
        val ySecondNumber = size * 0.12
        canvas.drawText("1", xSecondNumber.toFloat(), ySecondNumber.toFloat(), paint)

        val xThirdNumber = size * 0.5
        val yThirdNumber = size * 0.075
        canvas.drawText("2", xThirdNumber.toFloat(), yThirdNumber.toFloat(), paint)

        val xFourthNumber = size * 0.72
        val yFourthNumber = size * 0.14
        canvas.drawText("3", xFourthNumber.toFloat(), yFourthNumber.toFloat(), paint)
    }

    private fun drawBackground(canvas: Canvas) {
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL

        val radius = size / 2f
        val remotenessCircle = radius / 6

        canvas.drawCircle(size / 2f, size / 2f, radius - remotenessCircle, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }
}