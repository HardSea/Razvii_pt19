package com.pmacademy.razvii_pt19

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class RotatingFanImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : AppCompatImageView(context, attributeSet) {
    private var rotationDegrees = 0
    private var speedFan = 0
        set(state) {
            field = if (state >= 7 || state < 0) {
                0
            } else {
                state
            }
            invalidate()
        }

    init {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.electric_fan)
        setImageBitmap(bitmap)
    }

    fun changeSpeedFan() {
        speedFan+=2
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate(width / 2f, height / 2f)
        canvas.rotate(rotation(speedFan))
        canvas.translate(-width / 2f, -height / 2f)
        postInvalidateOnAnimation()
        super.onDraw(canvas)
    }

    private fun rotation(delta: Int): Float {
        rotationDegrees = (rotationDegrees + delta) % 360
        return rotationDegrees.toFloat()
    }
}