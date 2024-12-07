package com.capstone.centung.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstone.centung.databinding.FragmentProfileBinding
import com.capstone.centung.ui.about_app.AboutAppActivity
import com.capstone.centung.ui.login.LoginActivity

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtonActions()

    }

    private fun setupButtonActions() {
        binding.apply {

            btnAboutApp.setOnClickListener {
                startActivity(Intent(requireActivity(), AboutAppActivity::class.java))
            }

            btnRatingUs.setOnClickListener {

            }

            btnContactUs.setOnClickListener {

            }

            btnLogout.setOnClickListener {
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
                requireActivity().finish()
            }
        }
    }
}