package com.pmacademy.razvii_pt19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan)

        val funSwitcher = findViewById<PowerSwitcherImageView>(R.id.powerSwitcher)
        val fan = findViewById<RotatingFanImageView>(R.id.fan)
        funSwitcher.setOnClickListener {
            funSwitcher.changeSpeedFan()
            fan.changeSpeedFan()
        }
    }
}