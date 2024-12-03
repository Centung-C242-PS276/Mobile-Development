package com.capstone.centung.ui.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R


class RecommendationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        val solutionText = findViewById<TextView>(R.id.solutionText)
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        solutionText.text = """
            Solusi untuk "Stunting":
            1. Tambahkan makanan bergizi.
            2. Penuhi asupan vitamin.
            3. Rutin kontrol ke dokter.
        """.trimIndent()

        buttonBack.setOnClickListener {
            finish()
        }
    }
}