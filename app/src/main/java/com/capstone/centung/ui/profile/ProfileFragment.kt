package com.capstone.centung.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstone.centung.databinding.FragmentProfileBinding
import com.capstone.centung.ui.about_app.AboutAppActivity
import com.capstone.centung.ui.contact_us.ContactUsActivity
import com.capstone.centung.ui.edit_profile.EditProfileActivity
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
            btnEditProfile.setOnClickListener {
                startActivity(Intent(requireActivity(), EditProfileActivity::class.java))
            }
            btnAboutApp.setOnClickListener {
                startActivity(Intent(requireActivity(), AboutAppActivity::class.java))
            }
            btnContactUs.setOnClickListener {
                startActivity(Intent(requireActivity(), ContactUsActivity::class.java))
            }
            btnLogout.setOnClickListener {
                logoutUser()
            }
        }
    }

    private fun logoutUser() {
        val sharedPreferences =
            requireActivity().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()


        val intent = Intent(requireActivity(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}
