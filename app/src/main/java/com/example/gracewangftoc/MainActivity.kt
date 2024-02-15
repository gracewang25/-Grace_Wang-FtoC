package com.example.gracewangftoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBarCelsius = findViewById<SeekBar>(R.id.seekBarC)
        val textViewCelsius = findViewById<TextView>(R.id.textViewC)
        val seekBarFahrenheit = findViewById<SeekBar>(R.id.seekBarF)
        val textViewFahrenheit = findViewById<TextView>(R.id.textViewF)
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)
    }
}