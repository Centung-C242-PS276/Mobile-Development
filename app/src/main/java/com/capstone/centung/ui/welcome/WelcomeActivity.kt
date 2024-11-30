package com.capstone.centung.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.databinding.ActivityWelcomeBinding
import com.capstone.centung.ui.login.LoginActivity
import com.capstone.centung.ui.register.RegisterActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonActions()

    }

    private fun setupButtonActions() {
        binding.apply {
            btnLogin.setOnClickListener {
                setupIntent(LoginActivity::class.java)
            }
            btnSignUp.setOnClickListener {
                setupIntent(RegisterActivity::class.java)
            }
        }
    }

    private fun setupIntent(destination: Class<*>) {
        startActivity(Intent(this@WelcomeActivity, destination))
        finish()
    }
}