package com.example.ridebrave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ridebrave.databinding.Screen1Binding
import com.example.ridebrave.databinding.Screen3Binding

class Screen1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen1)

//        findViewById<Button>(R.id.b_screen1_get_start).setOnClickListener{
//            val intent = Intent(this, Screen2::class.java)
//            startActivity(intent)
//        }


    }
}