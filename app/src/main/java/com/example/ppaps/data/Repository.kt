package com.example.ppaps.data

import android.util.Log
import androidx.lifecycle.liveData
import com.example.ppaps.data.pref.UserModel
import com.example.ppaps.data.pref.UserPreference
import com.example.ppaps.data.remote.ApiService
import com.example.ppaps.data.response.LoginResponse
import com.example.ppaps.data.response.Response
import com.example.ppaps.data.response.UserResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.HttpException

class Repository private constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService,
    ) {
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    suspend fun register(username: String, password: String, nohp: String,name: String, ) = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.register(username, password, nohp, name)
            emit(ResultState.Success(response))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, Response::class.java)
            Log.e("Repository", errorBody.message.toString())
            emit(errorBody.message?.let { ResultState.Error(it) })
        }
    }

    suspend fun login(username: String, password: String) = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.login(username, password)
            emit(ResultState.Success(response))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, LoginResponse::class.java)
            emit(errorBody.message?.let { ResultState.Error(it) })
        }
    }

    suspend fun getUserData(token: String) = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.getUser("Bearer $token")
            emit(ResultState.Success(response))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, UserResponse::class.java)
            emit(errorBody.message?.let { ResultState.Error(it) })
        }
    }

    suspend fun uploadImage(url: String, photo: MultipartBody.Part, user_id: RequestBody) = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.upload("Bearer secret", url,  photo, user_id)
            emit(ResultState.Success(response))
        } catch (e: HttpException) {
//            val jsonInString = e.response()?.errorBody()?.string()
//            val errorBody = Gson().fromJson(jsonInString, UserResponse::class.java)
            emit(e.message?.let { ResultState.Error(it) })
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(userPreference: UserPreference, apiService: ApiService): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(userPreference, apiService)
            }.also { instance = it }
    }
}