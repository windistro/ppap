package com.example.ppaps.ui.main.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.ppaps.data.Repository
import com.example.ppaps.data.pref.UserModel

class ChangePasswordViewModel(private val repository: Repository) : ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
    suspend fun changePassword(token: String, oldPass: String, newPass: String, newPassConfirm: String) = repository.changePassword(token, oldPass, newPass, newPassConfirm)
}