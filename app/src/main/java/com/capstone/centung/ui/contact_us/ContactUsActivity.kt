package com.capstone.centung.ui.contact_us

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.databinding.ActivityContactUsBinding

class ContactUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtonActions()
        setupActionBackToolBar()
    }

    private fun setupButtonActions() {
        binding.apply {
            btnWhatsapp.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://api.whatsapp.com/send?phone=$WHATS_APP_NUMBER")
                    setPackage("com.whatsapp")
                }
                if (packageManager.resolveActivity(intent, 0) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@ContactUsActivity,
                        "WhatsApp tidak ditemukan",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            btnPhone.setOnClickListener {
                startActivity(Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$PHONE_NUMBER")
                })
            }
            btnEmail.setOnClickListener {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$EMAIL")
                }


                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                } else {

                    Toast.makeText(
                        this@ContactUsActivity,
                        "Tidak ada aplikasi email yang tersedia",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
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

    companion object {
        const val WHATS_APP_NUMBER = "082112053249"
        const val PHONE_NUMBER = "0218000685"
        const val EMAIL = "ppid.pusat@bkkbn.go.id"
    }
}