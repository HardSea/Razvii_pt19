package com.pmacademy.razvii_pt19

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setListeners()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.btn_show_fan).setOnClickListener {
            val intent = Intent(this, FanActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_show_posters).setOnClickListener {
            val intent = Intent(this, PostersActivity::class.java)
            startActivity(intent)
        }
    }
}