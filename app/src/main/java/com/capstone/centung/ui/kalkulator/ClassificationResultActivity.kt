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

        val buttonBackToolbar = findViewById<ImageView>(R.id.buttonBackToolbar)
        buttonBackToolbar.setOnClickListener {
            onBackPressed()
        }

        val textViewResultTop = findViewById<TextView>(R.id.textViewResultTop)
        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)
        val buttonSolusi = findViewById<Button>(R.id.buttonSolusi)
        val buttonBack = findViewById<Button>(R.id.buttonBack)


        val result = intent.getStringExtra("result")
        val gender = intent.getStringExtra("gender")
        val usia = intent.getIntExtra("usia", 0)
        val tinggi = intent.getFloatExtra("tinggi", 0f)

        textViewResultTop.text = "Hasil Klasifikasi: $result"

        textViewDetails.text = """
            Berdasarkan:
            Jenis Kelamin: $gender
            Tinggi Badan: $tinggi cm
            Usia: $usia bulan
        """.trimIndent()

        buttonSolusi.setOnClickListener {
            val intent = Intent(this, RecommendationActivity::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}