package com.example.ridebrave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Screen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen3)

        findViewById<Button>(R.id.b_screen3_get_start).setOnClickListener{
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
        }
    }
}