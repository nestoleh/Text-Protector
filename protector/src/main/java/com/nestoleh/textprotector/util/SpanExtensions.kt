package com.nestoleh.textprotector.util

import android.text.Spannable


fun CharSequence.substringBorders(substring: String): SubstringBorders {
    val start = indexOf(substring)
    return if (start >= 0) {
        SubstringBorders(
            start = start,
            end = start + substring.length
        )
    } else {
        SubstringBorders.notFound()
    }
}

fun Spannable.setSpan(span: Any, borders: SubstringBorders, flags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) {
    if (borders.isExist) {
        setSpan(span, borders.start, borders.end, flags)
    }
}

fun Spannable.setFullSpan(span: Any, flags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) {
    setSpan(span, 0, this.length, flags)
}