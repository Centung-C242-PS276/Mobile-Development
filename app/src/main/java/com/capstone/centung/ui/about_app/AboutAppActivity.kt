package com.capstone.centung.ui.about_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBackToolBar()
//        setupDesc()

    }

//    private fun setupDesc() {
//            val formattedDesc = """
//Centung is an innovative digital solution designed to predict and address the risk of stunting in children. By leveraging key health indicators such as nutritional intake, parental health history, and environmental factors, Centung empowers caregivers and healthcare professionals with real-time insights into a child's growth and development.
//The application utilizes advanced machine learning algorithms to analyze data and assess stunting risk levels, providing personalized recommendations to prevent and mitigate the condition. Through an intuitive interface, Centung delivers actionable guidance, health education, and progress tracki=ng to ensure timely interventions.
//By focusing on early detection and prevention, Centung aims to become a vital tool in combating stunting, supporting Indonesia’s efforts to improve child health outcomes and nurture a healthier, brighter future for its next generation.
//                """.trimIndent()
//        binding.tvDesc.text = formattedDesc
//    }

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