package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R.layout

class Page5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_page5)
        val h = findViewById<TextView>(R.id.Login)
        h.setOnClickListener {
            val intent =
                Intent(this, Page2::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }

        val send = findViewById<TextView>(R.id.send)
        send.setOnClickListener {
            val intent =
                Intent(this, Page6::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }

        val toparrow = findViewById<ImageView>(R.id.Toparrow)
        toparrow.setOnClickListener {
            val intent =
                Intent(this, Page2::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }
    }
}