package com.capstone.centung.ui.berita

import android.content.Context
import com.capstone.centung.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun loadNewsFromJson(context: Context): List<LocalNews> {
    val inputStream = context.resources.openRawResource(R.raw.news_data)
    val json = inputStream.bufferedReader().use { it.readText() }
    val type = object : TypeToken<List<LocalNews>>() {}.type
    return Gson().fromJson(json, type)
}