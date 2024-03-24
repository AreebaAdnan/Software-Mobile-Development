package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class Page2 : AppCompatActivity()
{


    lateinit var email: EditText
    private lateinit var pass: EditText
    lateinit var login: Button
    lateinit var auth: FirebaseAuth


    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)

        email=findViewById(R.id.emailinput)
        pass=findViewById(R.id.passwordinput)
        login=findViewById(R.id.Loginbutton)
        auth = FirebaseAuth.getInstance()
        login.setOnClickListener{
            login()
        }

        val fgtpsd = findViewById<TextView>(R.id.fgtpswd)
        fgtpsd.setOnClickListener {
            val intent =
                Intent(this, Page5::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }

        val login = findViewById<Button>(R.id.Loginbutton)
        login.setOnClickListener {
            val intent =
                Intent(this, Page7::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }

        val h = findViewById<TextView>(R.id.signup1)
        h.setOnClickListener {
            val intent = Intent(this, Page3::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }

    }

    private fun login()
    {
        val email = email.text.toString()
        val pass = pass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()

            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            }
        }

    }

