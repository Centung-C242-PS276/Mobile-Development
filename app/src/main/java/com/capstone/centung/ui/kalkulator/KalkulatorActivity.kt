package com.capstone.centung.ui.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R

class KalkulatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val editTextUsia = findViewById<EditText>(R.id.editTextUsia)
        val editTextTinggi = findViewById<EditText>(R.id.editTextTinggi)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)

        buttonHitung.setOnClickListener {
            val gender = spinnerGender.selectedItem.toString()
            val usia = editTextUsia.text.toString().toIntOrNull()
            val tinggi = editTextTinggi.text.toString().toFloatOrNull()
            if (usia == null || tinggi == null) {
                Toast.makeText(this, "Masukkan data yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val result = if (tinggi < 70 && usia > 12) "STUNTING" else "NORMAL"
            if (result == "STUNTING") {
                val intent = Intent(this, StuntingResultActivity::class.java)
                intent.putExtra("gender", gender)
                intent.putExtra("usia", usia)
                intent.putExtra("tinggi", tinggi)
                startActivity(intent)
            } else {
                val intent = Intent(this, NormalResultActivity::class.java)
                intent.putExtra("gender", gender)
                intent.putExtra("usia", usia)
                intent.putExtra("tinggi", tinggi)
                startActivity(intent)
            }
        }
    }
}