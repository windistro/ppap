package com.example.ppaps.ui.main.home

import androidx.lifecycle.ViewModel
import com.example.ppaps.data.Repository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class CameraViewModel(private val repository: Repository) : ViewModel() {
    suspend fun verification(file: MultipartBody.Part, user_id: RequestBody) = repository.verification(file, user_id)
}