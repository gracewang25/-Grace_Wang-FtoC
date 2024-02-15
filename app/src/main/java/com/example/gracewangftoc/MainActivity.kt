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
        val textViewConvertedCelsius = findViewById<TextView>(R.id.textViewConvertedCelsius)
        val textViewConvertedFahrenheit = findViewById<TextView>(R.id.textViewConvertedFahrenheit)

        // Initialize SeekBars to halfway points
        seekBarCelsius.progress = 50
        seekBarFahrenheit.progress = 122

        textViewCelsius.text = "50°C"
        textViewFahrenheit.text = "122°F"
        updateMessage(50, textViewMessage)

        seekBarCelsius.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val fahrenheit = progress * 9 / 5 + 32
                textViewConvertedFahrenheit.text = "$fahrenheit°F"
                textViewCelsius.text = "$progress°C"
                updateMessage(progress, textViewMessage)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBarFahrenheit.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (progress < 32) {
                    textViewFahrenheit.text = "$progress°F"
                    textViewConvertedCelsius.text = "0°C"
                } else {
                    val celsius = (progress - 32) * 5 / 9
                    textViewConvertedCelsius.text = "$celsius°C"
                    textViewFahrenheit.text = "$progress°F"
                    updateMessage(celsius, textViewMessage)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar?.progress ?: 0 < 32) {
                    seekBar?.progress = 32
                    textViewFahrenheit.text = "32°F"
                    textViewConvertedCelsius.text = "0°C"
                    updateMessage(0, textViewMessage)
                }
            }
        })

    }

    private fun updateMessage(celsius: Int, textViewMessage: TextView) {
        textViewMessage.text = if (celsius <= 20) {
            "I wish it were warmer."
        } else {
            "I wish it were colder."
        }
    }
}