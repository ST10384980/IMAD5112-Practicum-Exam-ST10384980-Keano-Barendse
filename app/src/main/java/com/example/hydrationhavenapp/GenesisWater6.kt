package com.example.hydrationhavenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

data class WaterIntakeArray(
    val WaterDate: String, //Date of Students Water Intake
    val WaterMorn: Double, //Morning Data of Students Water Intake
    val WaterAfter: Double, //Afternoon Data of Students Water Intake
    val WaterNote: String,  //Students Notes
) : Parcelable {



    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(), //Reading the Morning water intake data from the parcel
        parcel.readDouble(), //Read the Afternoon water intake from the parcel
        parcel.readString() ?: ""
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(WaterDate)
        parcel.writeDouble(WaterMorn)
        parcel.writeDouble(WaterAfter)
        parcel.writeString(WaterNote)
    }

    //Default Zero
    override fun describeContents(): Int {
        return 0
    }

    //Instances
    companion object CREATOR : Parcelable.Creator<WaterIntakeArray> {


        override fun createFromParcel(parcel: Parcel): WaterIntakeArray {
            return WaterIntakeArray(parcel)
        }


        override fun newArray(size: Int): Array<WaterIntakeArray?> {
            return arrayOfNulls(size)
        }
    }
}