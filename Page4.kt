package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R.layout
import com.example.myapplication.R.layout.*

class Page4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_page4)
        val h = findViewById<Button>(R.id.verifybutton)
        h.setOnClickListener {
            val intent =
                Intent(this, Page2::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }
    }
}