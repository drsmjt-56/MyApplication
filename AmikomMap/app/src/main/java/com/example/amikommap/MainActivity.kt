package com.example.amikommap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etLatitude : EditText = findViewById(R.id.etLatitude)
        val etLongitude : EditText = findViewById(R.id.etLongitude)
        val btMap : Button = findViewById(R.id.btMap)
        btMap.setOnClickListener {

            val latitude : Double = etLatitude.text.toString().toDouble()
            val longitude : Double = etLongitude.text.toString().toDouble()

            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("lat", latitude)
            intent.putExtra("lon", longitude)
            startActivity(intent)
        }

    }
}