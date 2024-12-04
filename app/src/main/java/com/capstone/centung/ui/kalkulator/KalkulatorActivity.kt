package com.capstone.centung.ui.kalkulator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.centung.R
import com.capstone.centung.data.RetrofitClient
import com.capstone.centung.data.response.StuntingRequest
import com.capstone.centung.data.response.StuntingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KalkulatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val editTextUsia = findViewById<EditText>(R.id.editTextUsia)
        val editTextTinggi = findViewById<EditText>(R.id.editTextTinggi)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)

        buttonHitung.setOnClickListener {
            val gender = spinnerGender.selectedItem.toString().lowercase()
            val usia = editTextUsia.text.toString().toIntOrNull()
            val tinggi = editTextTinggi.text.toString().toFloatOrNull()

            if (gender == "pilih jenis kelamin") {
                Toast.makeText(this, "Pilih jenis kelamin yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (gender != "laki-laki" && gender != "perempuan") {
                Toast.makeText(this, "Jenis kelamin harus 'laki-laki' atau 'perempuan'", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (usia == null || usia <= 0) {
                Toast.makeText(this, "Masukkan usia yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (tinggi == null || tinggi <= 0) {
                Toast.makeText(this, "Masukkan tinggi yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Log untuk debug
            Log.d("API_REQUEST", "Jenis kelamin: $gender, Usia: $usia, Tinggi: $tinggi")

            val request = StuntingRequest(
                umur_bulan = usia,
                jenis_kelamin = gender,
                tinggi = tinggi
            )

            RetrofitClient.instance.predictStunting(request)
                .enqueue(object : Callback<StuntingResponse> {
                    override fun onResponse(
                        call: Call<StuntingResponse>,
                        response: Response<StuntingResponse>
                    ) {
                        if (response.isSuccessful) {
                            val result = response.body()?.predictedClass

                            val intent = if (result == "Stunting" || result == "Severely Stunting") {
                                Intent(this@KalkulatorActivity, StuntingResultActivity::class.java)
                            } else {
                                Intent(this@KalkulatorActivity, NormalResultActivity::class.java)
                            }
                            intent.putExtra("result", result)
                            intent.putExtra("gender", gender)
                            intent.putExtra("usia", usia)
                            intent.putExtra("tinggi", tinggi)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@KalkulatorActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<StuntingResponse>, t: Throwable) {
                        Toast.makeText(this@KalkulatorActivity, "Kesalahan jaringan: ${t.message}", Toast.LENGTH_SHORT).show()
                        Log.e("API_ERROR", t.message.toString())
                    }
                })
        }


    }
}