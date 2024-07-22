package com.example.hydrationhavenapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class water4 : AppCompatActivity() {


    private val WaterIntakeData = ArrayList<WaterIntakeArray>()



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water4)




        val WaterDate = findViewById<EditText>(R.id.W4DateView)
        val WaterMorn = findViewById<EditText>(R.id.W4MornView)
        val WaterAfter = findViewById<EditText>(R.id.W4AfterView)
        val WaterNote = findViewById<EditText>(R.id.W4NoteView)

        val SaveButton4 = findViewById<Button>(R.id.W4Save)
        val NextButton4 = findViewById<Button>(R.id.W4Next)
        val ClearButton4 = findViewById<Button>(R.id.W4Clear)
        val LeaveButton4 = findViewById<Button>(R.id.W4ExitBTn)


        //Saving Field Data
        SaveButton4.setOnClickListener {

            val WDateData = WaterDate.text.toString()
            val WMorningData = WaterMorn.text.toString()
            val WAfternoonData = WaterAfter.text.toString()
            val WNoteData = WaterNote.text.toString()




            try {




                val WMorningDouble = WMorningData.toDouble()
                val WAfternoonDouble = WAfternoonData.toDouble()





                val entry = WaterIntakeArray(WDateData, WMorningDouble, WAfternoonDouble, WNoteData)
                WaterIntakeData.add(entry)
                Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
            } catch (e:NumberFormatException)
            {
                Toast.makeText(this,"Please Enter Water Intake Data", Toast.LENGTH_SHORT).show()
            }

        }


        //Using WaterIntake Array from GenesisWaterIntake MainActivity to calculate Data onto Water4
        NextButton4.setOnClickListener {
            val intent = Intent(this, water5::class.java)
            intent.putParcelableArrayListExtra("data", WaterIntakeData)
            startActivity(intent)


            Toast.makeText(this,"Calculating Data", Toast.LENGTH_SHORT).show()
        }

        //Clearing Data from fields Button
        ClearButton4.setOnClickListener {
            WaterDate.text.clear()
            WaterMorn.text.clear()
            WaterAfter.text.clear()
            WaterNote.text.clear()


            Toast.makeText(this,"Data Cleared", Toast.LENGTH_SHORT).show()
        }



        //Exiting Application Button
        LeaveButton4.setOnClickListener { finishAffinity()
        Toast.makeText(this,"Good Bye", Toast.LENGTH_SHORT).show()
        }









    }



}