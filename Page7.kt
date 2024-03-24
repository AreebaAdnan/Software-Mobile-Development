package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Page7 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<Datapage7>
    private lateinit var adapter: MyAdapter // Initialize adapter variable

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page7)
        recyclerView = findViewById(R.id.rv) // Initialize recyclerView

        arrayList = ArrayList() // Initialize arrayList
        adapter = MyAdapter(arrayList, this) // Initialize adaptera
        arrayList.add(Datapage7("Ali", "Android Developer", "Available", Uri.parse("android.resource://com.example.myapplication/drawable/man"))) // Add data to arrayList
        arrayList.add(Datapage7("Ali", "Android Developer", "Available", Uri.parse("android.resource://com.example.myapplication/drawable/man"))) // Add data to arrayList
        arrayList.add(Datapage7("Ali", "Android Developer", "Available", Uri.parse("android.resource://com.example.myapplication/drawable/man"))) // Add data to arrayList

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter // Set adapter to recyclerView

        // Create an Intent to start Page12 activity
        val imageView: ImageView = findViewById<ImageView>(R.id.plus)
        imageView.setOnClickListener {
            val intent = Intent(this, Page12::class.java)
            startActivity(intent)
        }
        // Create an Intent to start Page8 activity
        val search = findViewById<ImageView>(R.id.search)
        search.setOnClickListener {
            val intent = Intent(this, Page8::class.java)
            startActivity(intent)
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()

        // Receive input data from Intent
        val name = intent.getStringExtra("name")
        val skillset = intent.getStringExtra("skillset")
        val status = intent.getStringExtra("status")
        val imageUri = intent.getParcelableExtra<Uri>("Image") // Get the image URI

        // Add data to arrayList and notify adapter
        if (!name.isNullOrEmpty() && !skillset.isNullOrEmpty() && !status.isNullOrEmpty() && imageUri != null) {
            val newData = Datapage7(name, skillset, status, imageUri)
            arrayList.add(newData)
            adapter.notifyDataSetChanged()
        }
    }
}