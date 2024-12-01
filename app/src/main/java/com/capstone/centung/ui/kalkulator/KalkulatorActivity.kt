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
        setContentView(R.layout.activity_kalkulator) // Pastikan file layout ini ada

        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val editTextUsia = findViewById<EditText>(R.id.editTextUsia)
        val editTextTinggi = findViewById<EditText>(R.id.editTextTinggi)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)

        buttonHitung?.setOnClickListener {
            // Ambil input dari pengguna
            val gender = spinnerGender.selectedItem.toString()
            val usia = editTextUsia.text.toString().toIntOrNull()
            val tinggi = editTextTinggi.text.toString().toFloatOrNull()

            // Validasi input
            if (usia == null || tinggi == null) {
                Toast.makeText(this, "Masukkan data yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simulasi hasil klasifikasi (tanpa model)
            val result = if (tinggi < 70 && usia > 12) "STUNTING" else "NORMAL"

            // Pindah ke halaman hasil klasifikasi
            val intent = Intent(this, ClassificationResultActivity::class.java)
            intent.putExtra("result", result)
            intent.putExtra("gender", gender)
            intent.putExtra("usia", usia)
            intent.putExtra("tinggi", tinggi)
            startActivity(intent)
        }

    }
}