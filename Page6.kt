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

class Page6 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page6)
        val reset = findViewById<Button>(R.id.reset)
        reset.setOnClickListener {
            val intent =
                Intent(this, Page2::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }

        val h = findViewById<TextView>(R.id.Login)
        h.setOnClickListener {
            val intent =
                Intent(this, Page2::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }
    }

}