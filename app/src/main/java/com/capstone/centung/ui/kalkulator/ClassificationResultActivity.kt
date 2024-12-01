package com.capstone.centung.ui.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R

class ClassificationResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classification_result)

        // Tombol kembali di toolbar
        val buttonBackToolbar = findViewById<ImageView>(R.id.buttonBackToolbar)
        buttonBackToolbar.setOnClickListener {
            onBackPressed() // Kembali ke halaman sebelumnya
        }

        // Inisialisasi elemen UI lainnya
        val textViewResultTop = findViewById<TextView>(R.id.textViewResultTop) // TextView untuk hasil klasifikasi
        val textViewDetails = findViewById<TextView>(R.id.textViewDetails) // TextView untuk detail data
        val buttonSolusi = findViewById<Button>(R.id.buttonSolusi)
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        // Ambil data dari intent
        val result = intent.getStringExtra("result")
        val gender = intent.getStringExtra("gender")
        val usia = intent.getIntExtra("usia", 0)
        val tinggi = intent.getFloatExtra("tinggi", 0f)

        // Tampilkan hasil klasifikasi di atas
        textViewResultTop.text = "Hasil Klasifikasi: $result"

        // Tampilkan detail data di bawah hasil klasifikasi
        textViewDetails.text = """
            Berdasarkan:
            Jenis Kelamin: $gender
            Tinggi Badan: $tinggi cm
            Usia: $usia bulan
        """.trimIndent()

        // Tombol solusi
        buttonSolusi.setOnClickListener {
            val intent = Intent(this, RecommendationActivity::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }

        // Tombol kembali
        buttonBack.setOnClickListener {
            finish()
        }
    }
}