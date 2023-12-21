package com.example.ppaps.ui.main.call

import androidx.lifecycle.ViewModel
import com.example.ppaps.data.Repository

class CallViewModel(private val repository: Repository) : ViewModel() {
    suspend fun getHospital(token: String) = repository.getHospital(token)
}