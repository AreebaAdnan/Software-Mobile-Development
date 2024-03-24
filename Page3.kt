package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import androidx.appcompat.app.AppCompatActivity



class Page3 : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var cpass: EditText
    private lateinit var pass: EditText
    private lateinit var signin: Button
    lateinit var tvRedirectLogin: TextView
    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page3)

        // View Bindings
        email = findViewById(R.id.emailinput)
        cpass = findViewById(R.id.cpassinput)
        pass = findViewById(R.id.passinput)
        signin = findViewById(R.id.signbutton)
        // Initialising auth object
        auth = Firebase.auth



        val h = findViewById<TextView>(R.id.login)
        h.setOnClickListener {
            val intent =
                Intent(this, Page2::class.java)  // Replace with your actual activity class name
            startActivity(intent)
        }


    }

    private fun signInUser()
    {
        val email = email.text.toString()
        val pass = pass.text.toString()
        val confirmPassword = cpass.text.toString()
        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank())
        {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass != confirmPassword)
        {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()
                signin.setOnClickListener{
                    signInUser()
                    val intent = Intent(this, Page4::class.java)  // Replace with your actual activity class name
                    startActivity(intent)
                }
            }
            else
            {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}