package com.example.hydrationhavenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Water2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water2)


        val InitiadButton = findViewById<Button>(R.id.HEnter2)

        InitiadButton.setOnClickListener {

            val MyName = findViewById<EditText>(R.id.HStudent2)
            val MyNum = findViewById<EditText>(R.id.HNum2)

            val W3Name = MyName.text.toString()
            val W3Num = MyNum.text.toString()






            val intent = Intent(this, Water3:: class.java)
            intent.putExtra("StudentName", W3Name)
            intent.putExtra("StudentNumber", W3Num)
            startActivity(intent)
            finish()

            Toast.makeText(this, "Student Credentials", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.HExit2).setOnClickListener {


            finishAffinity()

            Toast.makeText(this,"GoodBye", Toast.LENGTH_SHORT).show()
        }
    }
}