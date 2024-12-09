package com.capstone.centung.ui.DashboardPemantauan

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.capstone.centung.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Komponen layout
        val statusText = findViewById<TextView>(R.id.currentStatus)
        val growthChart = findViewById<ImageView>(R.id.growthChart)

        // Set status anak
        val predictionResult = intent.getStringExtra("predictionResult") ?: "NORMAL"
        statusText.text = predictionResult
        if (predictionResult == "STUNTING") {
            statusText.setBackgroundResource(R.drawable.status_indicator_warning)
        } else {
            statusText.setBackgroundResource(R.drawable.status_indicator_safe)
        }
    }
}