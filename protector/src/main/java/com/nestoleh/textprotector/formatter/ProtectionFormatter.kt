package com.nestoleh.textprotector.formatter

interface ProtectionFormatter {
    fun format(data: CharSequence?): String
}