package com.example.gracewangftoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sbC = findViewById<SeekBar>(R.id.seekBarC)
        val tvC = findViewById<TextView>(R.id.textViewC)
        val sbF = findViewById<SeekBar>(R.id.seekBarF)
        val tvF = findViewById<TextView>(R.id.textViewF)
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)

        sbC.progress = 50
        sbF.progress = 122
        tvC.text = "50°C"
        tvF.text = "122°F"
        updateM(50, textViewMessage)

    }
    private fun updateM(celsius: Int, textViewMessage: TextView) {
        textViewMessage.text = if (celsius <= 20) {
            "I wish it were warmer."
        } else {
            "I wish it were colder."
        }
}