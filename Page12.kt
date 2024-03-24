package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ImageViewCompat
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityPage12Binding

class Page12 : AppCompatActivity() {

    private var imageUri: Uri? = null
    private lateinit var binding: ActivityPage12Binding

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPage12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            try {
                binding.PostedPhoto.setImageURI(uri)
                binding.PostedPhoto.scaleType = ImageView.ScaleType.FIT_XY
                imageUri = uri
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        binding.cameratext.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        val submitButton: TextView = binding.bottomrectext
        submitButton.setOnClickListener {
            val name = binding.Nameinput.text.toString()
            val description = binding.Desinput.text.toString()
            val status = binding.statusinput.text.toString()

            val intent = Intent(this, Page7::class.java).apply {
                putExtra("name", name)
                putExtra("description", description)
                putExtra("Image", imageUri?.toString())
                putExtra("status", status)
            }
            startActivity(intent)
        }

        val upload = findViewById<TextView>(R.id.bottomrectext)
        upload.setOnClickListener {
            val intent = Intent(this, Page7::class.java)
            startActivity(intent)
        }
    }
}
