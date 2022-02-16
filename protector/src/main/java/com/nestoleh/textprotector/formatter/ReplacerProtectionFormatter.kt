package com.nestoleh.textprotector.formatter

class ReplacerProtectionFormatter(
    private val replacer: CharSequence
) : ProtectionFormatter {

    override fun format(data: CharSequence?): String {
        return if (data == null) {
            ""
        } else {
            replacer.repeat(data.length)
        }
    }
}