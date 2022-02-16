package com.nestoleh.textprotector.widget

import android.content.Context
import android.text.Spanned
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.nestoleh.textprotector.span.ConfigurableProtectedSpan

open class ProtectedTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var isProtectionEnabled: Boolean = false
        set(value) {
            if (field != value) {
                field = value
                updateSpansState()
                invalidate()
            }
        }

    private var protectedSpans: MutableList<ConfigurableProtectedSpan>? = null

    override fun setText(text: CharSequence?, type: BufferType?) {
        if (protectedSpans == null) {
            protectedSpans = ArrayList()
        }
        protectedSpans?.clear()
        if (text is Spanned) {
            val spans = text.getSpans(0, text.length, ConfigurableProtectedSpan::class.java)
            protectedSpans?.addAll(spans)
            updateSpansState()
        }
        super.setText(text, type)
    }

    private fun updateSpansState() {
        protectedSpans?.forEach { it.isProtectionEnabled = isProtectionEnabled }
    }
}