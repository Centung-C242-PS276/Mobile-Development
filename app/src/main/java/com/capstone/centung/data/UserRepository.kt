package com.capstone.centung.data

import com.capstone.centung.data.DataStoreHelper
import com.capstone.centung.data.api.ApiService
import com.capstone.centung.data.response.ErrorResponse
import com.capstone.centung.data.response.LoginResponse
import com.capstone.centung.data.response.RegisterResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import kotlinx.coroutines.flow.flowOn

class UserRepository(
    private val apiService: ApiService,
    private val dataStoreHelper: DataStoreHelper
) {

    suspend fun saveToken(token: String) {
        dataStoreHelper.saveToken(token)
    }

    val token: Flow<String?> = dataStoreHelper.token


    fun register(name: String, email: String, password: String): Flow<Result<RegisterResponse>> {
        return flow {
            emit(Result.Loading)
            try {
                val response = apiService.register(name, email, password)
                emit(Result.Success(response))
            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorMessage = if (errorBody != null) {
                    Gson().fromJson(errorBody, ErrorResponse::class.java).message
                } else {
                    "Unknown error occurred"
                }
                emit(Result.Error(Exception(errorMessage)))


            }
        }.flowOn(Dispatchers.IO)
    }

    fun login(email: String, password: String): Flow<Result<LoginResponse>> {
        return flow {
            emit(Result.Loading)
            try {
                val response = apiService.login(email, password)
                response.loginResult?.token?.let { saveToken(it) }
                emit(Result.Success(response))
            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorMessage = if (errorBody != null) {
                    Gson().fromJson(errorBody, ErrorResponse::class.java).message
                } else {
                    "Terjadi kesalahan tidak diketahui"
                }
                emit(Result.Error(Exception(errorMessage)))
            } catch (e: IOException) {
                emit(Result.Error(Exception("Koneksi gagal. Pastikan perangkat Anda terhubung ke internet.")))
            } catch (e: Exception) {
                emit(Result.Error(Exception("Error tidak diketahui: ${e.message}")))
            }
        }.flowOn(Dispatchers.IO)
    }

}