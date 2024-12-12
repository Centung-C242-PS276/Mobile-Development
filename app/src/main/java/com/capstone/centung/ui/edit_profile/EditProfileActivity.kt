package com.capstone.centung.ui.edit_profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBackToolBar()

        binding.edtEmail.isEnabled = false
    }

    private fun setupActionBackToolBar() {
        binding.apply {
            setSupportActionBar(mToolbar)
            mToolbar.apply {
                setNavigationIcon(R.drawable.ic_arrow_back)
                setNavigationOnClickListener {
                    finish()
                }
            }
        }
    }
}