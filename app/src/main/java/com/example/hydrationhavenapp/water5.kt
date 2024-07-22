package com.example.hydrationhavenapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class water5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water5)

        val WaterInputData = intent.getParcelableArrayListExtra<WaterIntakeArray>("data") ?: arrayListOf()
        val WaterList = findViewById<ListView>(R.id.IntakeDataList)
        val WaterAverage = findViewById<TextView>(R.id.WaterDataBox)
        val BackSplash = findViewById<Button>(R.id.WaterBackBtn)

        //Calculate averages
        var TotalMorningIntake = 0.0
        var TotalAfternoonIntake = 0.0

        WaterInputData.forEach{
            TotalMorningIntake += it.WaterMorn
            TotalAfternoonIntake += it.WaterAfter
        }

        val averageMorning = if (WaterInputData.isNotEmpty()) TotalMorningIntake / WaterInputData.size else 0.0
        val averageAfternoon = if (WaterInputData.isNotEmpty()) TotalAfternoonIntake / WaterInputData.size else 0.0
        WaterAverage.text = "Weekly Morning Intake Average : $averageMorning\nWeekly Afternoon Intake Average: $averageAfternoon"

        //Populate ListView
        val WaterDetailedInfoList = WaterInputData.map { "Date: ${it.WaterDate}\nMorning Water Intake (L): ${it.WaterMorn}\nAfternoon Water Intake (L): ${it.WaterAfter}\nNotes: ${it.WaterNote}" }
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, WaterDetailedInfoList)
        WaterList.adapter = adapter

        BackSplash.setOnClickListener {
            finish()
        }


    }
}