package com.capstone.centung.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.databinding.ActivityRegisterBinding
import com.capstone.centung.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonActions()
    }

    private fun setupButtonActions() {
        binding.apply {
            tvBtnLogin.setOnClickListener {
                setupSignInAction()
            }
            btnRegister.setOnClickListener {
                setupSignInAction()
            }

        }
    }

    private fun setupSignInAction() {
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
        finish()
    }
}