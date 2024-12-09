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
import com.capstone.centung.ui.about_stunting.AboutStuntingActivity

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

        // Tambahkan aksi pada tombol
        binding.btnCheckNow.setOnClickListener {
            // Pindah ke KalkulatorActivity
            val intent = Intent(requireContext(), KalkulatorActivity::class.java)
            startActivity(intent)
        }
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupButtonActions()
//    }
//
//    private fun setupButtonActions() {
//        binding.apply {
//            btnLearnMore.setOnClickListener {
//                startActivity(Intent(requireActivity(), AboutStuntingActivity::class.java))
//            }
//       }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
