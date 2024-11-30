package com.capstone.centung

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecommendationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        val solutionText = findViewById<TextView>(R.id.solutionText)
        val result = intent.getStringExtra("result")

        if (result == "STUNTING") {
            solutionText.text = """
                Solusi untuk "Stunting"

1. **Tambahkan Makanan Bergizi**
    - Berikan MPASI (Makanan Pendamping ASI) yang kaya energi dan nutrisi, terutama makanan berbasis protein.
    - Teruskan pemberian ASI hingga usia 2 tahun.
2. **Edukasi Pola Makan**
    - Edukasi orang tua mengenai pentingnya makanan bergizi dan porsi yang sesuai untuk anak.
    - Berikan panduan menu sehat untuk balita sesuai usia.
3. **Pemberian Vitamin dan Suplemen**
    - Pastikan anak menerima vitamin tambahan seperti vitamin A dan tablet zat besi.
    - Lakukan imunisasi rutin untuk mencegah penyakit yang dapat menghambat tumbuh kembang.
4. **Manfaatkan Program Pemerintah**
    - Daftarkan anak pada program PMT (Pemberian Makanan Tambahan) di Posyandu atau Puskesmas terdekat.
    - Gunakan layanan kesehatan gratis yang tersedia untuk anak dengan risiko stunting.
            """.trimIndent()
        } else {
            solutionText.text = "Normal \n" +
                    "\n" +
                    "- \"Anak Anda berada dalam kategori normal. Pertahankan kondisi ini dengan:\n" +
                    "    - Memberikan makanan bergizi seimbang setiap hari.\n" +
                    "    - Memastikan anak aktif secara fisik dan memiliki waktu istirahat yang cukup.\n" +
                    "    - Melakukan pemeriksaan kesehatan secara berkala.\""
        }
    }
}