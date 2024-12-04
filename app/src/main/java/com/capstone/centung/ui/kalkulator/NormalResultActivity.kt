package com.capstone.centung.ui.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R

class NormalResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_result)

        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val imageViewCenter = findViewById<ImageView>(R.id.imageViewCenter)
        imageViewCenter.setImageResource(R.drawable.doctor)
        val textTop = findViewById<TextView>(R.id.textViewResultTop)


        // Ambil data dari intent
        val result = intent.getStringExtra("result")
        val gender = intent.getStringExtra("gender")
        val usia = intent.getIntExtra("usia", 0)
        val tinggi = intent.getFloatExtra("tinggi", 0f)

        textTop.text = "Hasil Klasifikasi: $result"
        textViewDetails.text = """
            Berdasarkan:
            Jenis Kelamin: $gender
            Tinggi Badan: $tinggi cm
            Usia: $usia bulan
        """.trimIndent()

        buttonBack.setOnClickListener {
            finish()
        }
    }
}