package com.capstone.centung.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.centung.R
import com.capstone.centung.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Komponen layout
        val statusText: TextView = view.findViewById(R.id.currentStatus)
        val growthChart: ImageView = view.findViewById(R.id.growthChart)

        // Set status anak
        val predictionResult = arguments?.getString("predictionResult") ?: "NORMAL"
        statusText.text = predictionResult
        if (predictionResult == "STUNTING") {
            statusText.setBackgroundResource(R.drawable.status_indicator_warning)
        } else {
            statusText.setBackgroundResource(R.drawable.status_indicator_safe)
        }
    }
}
