package com.capstone.centung.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.centung.ui.kalkulator.KalkulatorActivity
import com.capstone.centung.databinding.FragmentHomeBinding
import com.capstone.centung.ui.DashboardPemantauan.DashboardActivity
import com.capstone.centung.ui.about_stunting.AboutStuntingActivity
import com.capstone.centung.ui.kalkulator.RecommendationActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheckNow.setOnClickListener {
            val intent = Intent(requireContext(), KalkulatorActivity::class.java)
            startActivity(intent)
        }


        binding.cardAboutStunting.setOnClickListener {
            val intent = Intent(requireContext(), AboutStuntingActivity::class.java)
            startActivity(intent)
        }

        binding.pertumbuhan.setOnClickListener {
            val intent = Intent(requireContext(), DashboardActivity::class.java)
            startActivity(intent)
        }

        binding.rekomendasi.setOnClickListener {
            val intent = Intent(requireContext(), RecommendationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
