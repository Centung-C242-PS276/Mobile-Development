package com.capstone.centung.ui.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.ui.bottom_navbar.MainActivity


class RecommendationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        val buttonBack = findViewById<Button>(R.id.buttonBack)

        buttonBack.setOnClickListener {
            // Pindah ke MainActivity dan arahkan ke HomeFragment
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("navigateTo", "home") // Flag untuk navigasi
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish() // Tutup RecommendationActivity
        }
    }
}
