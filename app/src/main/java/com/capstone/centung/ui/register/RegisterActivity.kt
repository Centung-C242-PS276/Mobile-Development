package com.capstone.centung.ui.register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.data.AuthViewModel
import com.capstone.centung.data.Injection
import com.capstone.centung.data.Result
import com.capstone.centung.data.ViewModelFactory
import com.capstone.centung.ui.login.LoginActivity
import com.capstone.centung.utils.components.CustomEditText

class RegisterActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModels {
        ViewModelFactory(Injection.provideRepository(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameField = findViewById<CustomEditText>(R.id.edt_name)
        val emailField = findViewById<CustomEditText>(R.id.edt_email)
        val passwordField = findViewById<CustomEditText>(R.id.edt_password)
        val registerButton = findViewById<Button>(R.id.btn_register)
        val loginTextView = findViewById<TextView>(R.id.tv_btn_login)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        viewModel.registerResult.observe(this) { result ->
            when (result) {
                is Result.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    registerButton.isEnabled = false
                }
                is Result.Success -> {
                    progressBar.visibility = View.GONE
                    registerButton.isEnabled = true
                    Toast.makeText(this, result.data.message ?: "Register Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
                is Result.Error -> {
                    progressBar.visibility = View.GONE
                    registerButton.isEnabled = true // Mengaktifkan kembali tombol register
                    Toast.makeText(this, "Error: ${result.exception.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        passwordField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val errorMessage = if (s.isNullOrEmpty() || s.length < 8) {
                    "Password tidak boleh kurang dari 8 karakter"
                } else null
                passwordField.error = errorMessage
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        registerButton.setOnClickListener {
            val name = nameField.inputText.trim()
            val email = emailField.inputText.trim()
            val password = passwordField.inputText.trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.error = "Email tidak valid"
                return@setOnClickListener
            }

            viewModel.register(name, email, password)
        }

        loginTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
