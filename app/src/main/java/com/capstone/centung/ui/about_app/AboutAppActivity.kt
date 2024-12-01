package com.capstone.centung.ui.about_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDesc()
        setupActionBackToolBar()

    }

    private fun setupDesc() {
        val formattedDesc = """
                Our project aims to develop an innovative app that predicts a child’s risk of stunting by analyzing key health indicators. 
                The tool is designed to empower caregivers and health professionals by providing early warnings and tailored interventions. 
                The research underlying the app focuses on identifying the most significant determinants of health and shows how early risk 
                detection can facilitate impactful preventive actions.

                Through real-time analysis and personalized recommendations, the app supports families and health providers in addressing 
                the root causes of stunting. Our initiative aligns with the national strategy to reduce stunting prevalence, offering accessible 
                and effective educational resources to promote healthier communities.
            """.trimIndent()
        binding.tvDesc.text = formattedDesc
    }

    private fun setupActionBackToolBar() {
        binding.apply {
            setSupportActionBar(mToolbar)
            mToolbar.apply {
                setNavigationIcon(R.drawable.ic_arrow_back)
                setNavigationOnClickListener {
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}