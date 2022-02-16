package com.nestoleh.textprotector.span

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.ReplacementSpan
import com.nestoleh.textprotector.formatter.ProtectionFormatter
import com.nestoleh.textprotector.util.updateWithPaint

class ProtectedSpan(
    private val formatter: ProtectionFormatter
) : ReplacementSpan() {

    override fun getSize(paint: Paint, text: CharSequence, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        fm?.updateWithPaint(paint)
        val formattedText = reformatText(text, start, end)
        return measureText(paint, formattedText.text, formattedText.start, formattedText.end)
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
        val formattedText = reformatText(text, start, end)
        canvas.drawText(formattedText.text, formattedText.start, formattedText.end, x, y.toFloat(), paint)
    }

    private fun reformatText(text: CharSequence, start: Int, end: Int): FormattedText {
        val partToFormat = text.substring(start, end)
        val formattedPart = formatter.format(partToFormat)
        return FormattedText(
            text = text.substring(0, start) + formattedPart + text.substring(end, text.length),
            start = start,
            end = start + formattedPart.length
        )
    }

    private fun measureText(paint: Paint, text: CharSequence, start: Int, end: Int): Int {
        val size = paint.measureText(text, start, end)
        return size.toInt()
    }

    private data class FormattedText(
        val text: String,
        val start: Int,
        val end: Int
    )
    
}