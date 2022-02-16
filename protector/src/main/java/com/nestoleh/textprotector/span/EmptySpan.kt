package com.nestoleh.textprotector.span

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.ReplacementSpan
import com.nestoleh.textprotector.util.updateWithPaint

internal class EmptySpan : ReplacementSpan() {

    override fun getSize(paint: Paint, text: CharSequence?, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        fm?.updateWithPaint(paint)
        return paint.measureText(text, start, end).toInt()
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        canvas.drawText(text, start, end, x, y.toFloat(), paint)
    }

}