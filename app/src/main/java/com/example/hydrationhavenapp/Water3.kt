package com.example.hydrationhavenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Water3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water3)


        val intent = intent
        val W3nameData = intent.getStringExtra("StudentName")
        val W3numData = intent.getStringExtra("StudentNumber")

        //Display the name and student number in a TextView
        val textView = findViewById<TextView>(R.id.WaterReview)
        textView.text = "Name: $W3nameData\nStudent Number: $W3numData"


        val Page4Button = findViewById<Button>(R.id.Pg3Btn)


        Page4Button.setOnClickListener {
            val intent = Intent(this, water4::class.java)
            startActivity(intent)

            Toast.makeText(this,"Insert Water Data", Toast.LENGTH_SHORT).show()
        }
    }
}