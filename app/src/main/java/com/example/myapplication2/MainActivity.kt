package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
var  apiKey = "8d6d12d5cd91d80cc1c8c45439cf01cf"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.searchButton)
        button.setOnClickListener {
            getWeather()
        }
    }
    private fun getWeather() {
        val searchInput = findViewById<EditText>(R.id.searchInput)
        try {
            if (searchInput.text.isNotEmpty()) {

                var fullURL = "http://api.openweathermap.org/data/2.5/forecast?id=&524901&units=metric&appid=$apiKey"
                val queue = Volley.newRequestQueue(this)
                val stringRequest=StringRequest(
                    Request.Method.POST,fullURL,{response ->
                        println(response.toString())
                    },{ println(it.message)}
                )
                queue.add(stringRequest)
            }
        }catch (err:Exception){

        }



    }
}