package com.example.rainrader

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.util.Calendar


class Weatherpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weatherpage)

        val calendar = Calendar.getInstance().time
        val dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(calendar)
        val dateTextView = findViewById<TextView>(R.id.current_date)
        dateTextView.text = dateFormat

    }
}