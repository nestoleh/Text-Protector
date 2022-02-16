package com.nestoleh.textprotector.span

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.ReplacementSpan
import com.nestoleh.textprotector.formatter.ProtectionFormatter

class ConfigurableProtectedSpan(
    var isProtectionEnabled: Boolean = false,
    private val formatter: ProtectionFormatter
) : ReplacementSpan() {

    private val protectedSpan: ReplacementSpan by lazy { ProtectedSpan(formatter) }
    private val emptySpan: ReplacementSpan by lazy { EmptySpan() }

    private val span: ReplacementSpan
        get() = if (isProtectionEnabled) protectedSpan else emptySpan

    override fun getSize(paint: Paint, text: CharSequence, start: Int, end: Int, fm: Paint.FontMetricsInt?): Int {
        return span.getSize(paint, text, start, end, fm)
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        span.draw(canvas, text, start, end, x, top, y, bottom, paint)
    }

}