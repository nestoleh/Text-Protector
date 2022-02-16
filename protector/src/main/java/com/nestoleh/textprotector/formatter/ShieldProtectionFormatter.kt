package com.nestoleh.textprotector.formatter

import com.nestoleh.textprotector.formatter.shield.Shield

class ShieldProtectionFormatter(
    private val shield: Shield
) : ProtectionFormatter {
    override fun format(data: CharSequence?): String {
        return if (data == null) {
            ""
        } else {
            val hash = data.hashCode()
            shield.shieldByIndex(hash)
        }
    }
}