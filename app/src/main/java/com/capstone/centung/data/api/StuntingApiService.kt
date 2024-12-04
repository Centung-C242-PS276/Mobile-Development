package com.capstone.centung.data.api

import com.capstone.centung.data.response.StuntingRequest
import com.capstone.centung.data.response.StuntingResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface StuntingApiService {
    @POST("predict")
    fun predictStunting(
        @Body request: StuntingRequest
    ): Call<StuntingResponse>
}