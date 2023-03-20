package com.example.ridebrave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            run {
                startActivity(Intent(this@MainActivity, SliderActivity::class.java))
            }
        }, 1000)

        // move to another screen

    }
}