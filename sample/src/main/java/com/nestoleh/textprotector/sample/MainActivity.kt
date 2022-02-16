package com.nestoleh.textprotector.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nestoleh.textprotector.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val ui: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        initData()
    }

    private fun initUI() {
        ui.protectedModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // TODO: enable/disable protected mode
        }
    }

    private fun initData() {
        val amountStr = "1 000 000.00"
        ui.amount.text = amountStr

        val amountMessageStr = getString(R.string.test_data_amount_message, "19 000.99", "2 199.55", "12/22/2022")
        ui.amountMessage.text = amountMessageStr
    }
}