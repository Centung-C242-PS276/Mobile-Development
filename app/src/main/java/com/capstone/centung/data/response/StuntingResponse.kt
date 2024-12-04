package com.capstone.centung.data.response

import com.google.gson.annotations.SerializedName

data class StuntingResponse(

    @field:SerializedName("user_input")
    val userInput: UserInput? = null,

    @field:SerializedName("predicted_class")
    val predictedClass: String? = null,

    @field:SerializedName("prediction_raw")
    val predictionRaw: List<Float?>? = null
)

data class UserInput(

    @field:SerializedName("umur_bulan")
    val umurBulan: Int? = null,

    @field:SerializedName("jenis_kelamin")
    val jenisKelamin: String? = null,

    @field:SerializedName("tinggi")
    val tinggi: Float? = null
)


data class StuntingRequest(
    val umur_bulan: Int,
    val jenis_kelamin: String,
    val tinggi: Float
)