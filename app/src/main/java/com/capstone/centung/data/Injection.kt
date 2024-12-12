package com.capstone.centung.data

import android.content.Context
import com.capstone.centung.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-auth-api-343378515387.asia-southeast2.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        val dataStoreHelper = DataStoreHelper(context)

        return UserRepository(apiService, dataStoreHelper)
    }
}