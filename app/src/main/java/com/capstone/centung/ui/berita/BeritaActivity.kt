package com.capstone.centung.ui.berita

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.centung.R

class BeritaActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        val recyclerView = findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val newsList = loadNewsFromJson(this)
        recyclerView.adapter = NewsAdapter(newsList)


        val pageTitle = findViewById<TextView>(R.id.tvPageTitle)
        pageTitle.text = "Berita Terkait Stunting"
    }
}