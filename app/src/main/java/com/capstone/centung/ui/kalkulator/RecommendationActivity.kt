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
            Rekomendasi Solusi Penanganan Stunting:
            1. Pastikan anak mendapatkan asupan gizi yang cukup, termasuk protein, zat besi, dan vitamin.
            2. Jadwalkan kunjungan ke dokter atau ahli gizi untuk memantau perkembangan anak.
            3. Berikan imunisasi yang lengkap sesuai usia.
            4. Ciptakan lingkungan yang bersih untuk mengurangi risiko infeksi.
        """.trimIndent()

        buttonBack.setOnClickListener {
            finish()
        }
    }
}