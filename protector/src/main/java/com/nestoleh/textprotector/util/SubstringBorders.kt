package com.nestoleh.textprotector.util

data class SubstringBorders(
    val start: Int,
    val end: Int
) {

    val isExist: Boolean
        get() = start >= 0 && end >= 0

    companion object {
        fun notFound() = SubstringBorders(-1, -1)
    }
}