package com.example.myapplication56

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerDomisili: Spinner = findViewById(R.id.spinnerDomisili)
        val btnSubmit: Button = findViewById(R.id.btn_submit_register)
        val checkBox: CheckBox = findViewById(R.id.checkBox)

        btnSubmit.setOnClickListener {
            val kotaDipilih = spinnerDomisili.selectedItem.toString()

            if (checkBox.isChecked) {
                Toast.makeText(
                    this,
                    "Registrasi berhasil! Anda memilih kota: $kotaDipilih",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Harap setujui syarat dan ketentuan terlebih dahulu.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}