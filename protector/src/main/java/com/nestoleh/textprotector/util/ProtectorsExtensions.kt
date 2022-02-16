package com.nestoleh.textprotector.util

import com.nestoleh.textprotector.formatter.ReplacerProtectionFormatter
import com.nestoleh.textprotector.formatter.ShieldProtectionFormatter
import com.nestoleh.textprotector.formatter.shield.EmojiShield
import com.nestoleh.textprotector.span.ConfigurableProtectedSpan


fun EmojiProtectionSpan(
    isProtectionEnabled: Boolean = false
) = ConfigurableProtectedSpan(
    isProtectionEnabled = isProtectionEnabled,
    formatter = ShieldProtectionFormatter(EmojiShield)
)

fun ReplacerProtectionSpan(
    isProtectionEnabled: Boolean = false,
    replacer: CharSequence = "*"
) = ConfigurableProtectedSpan(
    isProtectionEnabled = isProtectionEnabled,
    formatter = ReplacerProtectionFormatter(replacer)
)