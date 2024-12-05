package com.capstone.centung.ui.first

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.databinding.ActivityFirstBinding
import com.capstone.centung.ui.login.LoginActivity
import com.capstone.centung.ui.register.RegisterActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
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
        startActivity(Intent(this@FirstActivity, destination))
        finish()
    }
}