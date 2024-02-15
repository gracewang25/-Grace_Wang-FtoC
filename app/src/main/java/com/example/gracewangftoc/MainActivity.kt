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

        // Update initial text views to reflect the halfway points
        val initialCelsius = 50
        val initialFahrenheit = celsiusToFahrenheit(initialCelsius)
        textViewCelsius.text = getString(R.string.celsius_format, initialCelsius)
        textViewFahrenheit.text = getString(R.string.fahrenheit_format, initialFahrenheit)

        // Set initial progress for SeekBars
        seekBarCelsius.progress = initialCelsius
        seekBarFahrenheit.progress = initialFahrenheit

        // Update message based on the initial temperature
        updateMessage(initialCelsius, textViewMessage)

        seekBarCelsius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val fahrenheit = celsiusToFahrenheit(progress)
                textViewCelsius.text = getString(R.string.celsius_format, progress)
                textViewFahrenheit.text = getString(R.string.fahrenheit_format, fahrenheit)
                updateMessage(progress, textViewMessage)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarFahrenheit.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val celsius = fahrenheitToCelsius(progress)
                if (progress < 32) {
                    textViewFahrenheit.text = getString(R.string.fahrenheit_format, 32)
                    textViewCelsius.text = getString(R.string.celsius_format, 0)
                } else {
                    textViewFahrenheit.text = getString(R.string.fahrenheit_format, progress)
                    textViewCelsius.text = getString(R.string.celsius_format, celsius)
                }
                updateMessage(celsius, textViewMessage)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar?.progress ?: 0 < 32) {
                    seekBar?.progress = 32
                }
            }
        })
    }

    private fun celsiusToFahrenheit(celsius: Int): Int = (celsius * 9 / 5) + 32

    private fun fahrenheitToCelsius(fahrenheit: Int): Int = (fahrenheit - 32) * 5 / 9

    private fun updateMessage(celsius: Int, textViewMessage: TextView) {
        textViewMessage.text = if (celsius <= 20) {
            "I wish it were warmer."
        } else {
            "I wish it were colder."
        }
    }
}
