package com.example.rainrader

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.rainrader.network.NetworkService
import com.example.rainrader.response.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

        GlobalScope.launch(Dispatchers.Main) {
            val response = fetchWeather("Amsterdam")
            val temperatureTextView = findViewById<TextView>(R.id.temperatureTextView)
            val windDescriptionTextView = findViewById<TextView>(R.id.wind_description)
            val rainDescriptionTextView = findViewById<TextView>(R.id.rain_description)

            temperatureTextView.text = "${response.main.temp}°C"
            windDescriptionTextView.text = "Wind: ${response.wind.speed} m/s"
            rainDescriptionTextView.text = "Rain: ${response.rain?.`1h`} mm"
        }
    }
    // Make fetchWeather a suspend function
    private suspend fun fetchWeather(location: String): WeatherResponse {
        return NetworkService.weatherApiService.getWeather(location, apiKey = "69834d6941c88685ef3b2411f27170eb")
    }
}
