package com.example.ridebrave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen2)

        findViewById<Button>(R.id.b_screen2_get_start).setOnClickListener{
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
        }
    }
}