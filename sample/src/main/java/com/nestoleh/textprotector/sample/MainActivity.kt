package com.nestoleh.textprotector.sample

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nestoleh.textprotector.sample.databinding.ActivityMainBinding
import com.nestoleh.textprotector.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val ui: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        initData()
    }

    private fun initUI() {
        ui.protectedModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            ui.amount.isProtectionEnabled = isChecked
            ui.amountMessage.isProtectionEnabled = isChecked
        }
    }

    private fun initData() {
        ui.amount.text = SpannableString("1 000 000.99").apply {
            setFullSpan(EmojiProtectionSpan())
        }

        val spentAmount = "19 000.99"
        val minPaymentAmount = "2 199.55"
        val graceDate = "12/22/2022"
        val amountMessageStr = getString(R.string.test_data_amount_message, spentAmount, minPaymentAmount, graceDate)
        ui.amountMessage.text = SpannableString(amountMessageStr).apply {
            setSpan(EmojiProtectionSpan(), this.substringBorders(spentAmount))
            setSpan(EmojiProtectionSpan(), this.substringBorders(minPaymentAmount))
            setSpan(ReplacerProtectionSpan(), this.substringBorders(graceDate))
        }
    }
}