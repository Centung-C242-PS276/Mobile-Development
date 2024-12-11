package com.capstone.centung.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.data.AuthViewModel
import com.capstone.centung.data.Injection
import com.capstone.centung.data.ViewModelFactory
import com.capstone.centung.ui.bottom_navbar.MainActivity
import com.capstone.centung.data.Result
import com.capstone.centung.ui.register.RegisterActivity
import com.capstone.centung.utils.components.CustomEditText

class LoginActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModels {
        ViewModelFactory(Injection.provideRepository(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val emailField = findViewById<CustomEditText>(R.id.edt_email)
        val passwordField = findViewById<CustomEditText>(R.id.edt_password)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val signUpTextView = findViewById<TextView>(R.id.tv_btn_register)


        viewModel.loginResult.observe(this) { result ->
            when (result) {
                is Result.Loading -> loginButton.isEnabled = false
                is Result.Success -> {
                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                is Result.Error -> {
                    Toast.makeText(this, "Error: ${result.exception.message}", Toast.LENGTH_SHORT).show()
                }
            }
            loginButton.isEnabled = true
        }


        loginButton.setOnClickListener {
            val email = emailField.inputText.toString().trim()
            val password = passwordField.inputText .toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.login(email, password)
        }


        signUpTextView.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
