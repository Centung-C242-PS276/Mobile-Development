package com.capstone.centung.data

import android.content.Context
import com.capstone.centung.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://story-api.dicoding.dev/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        val dataStoreHelper = DataStoreHelper(context)

        return UserRepository(apiService, dataStoreHelper)
    }
}