package com.nestoleh.textprotector.util

import android.graphics.Paint

internal fun Paint.FontMetricsInt.updateWithPaint(paint: Paint) {
    val paintFontMetrics = paint.fontMetrics
    ascent = paintFontMetrics.ascent.toInt()
    bottom = paintFontMetrics.bottom.toInt()
    descent = paintFontMetrics.descent.toInt()
    leading = paintFontMetrics.leading.toInt()
    top = paintFontMetrics.top.toInt()
}