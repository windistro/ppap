package com.example.ppaps.data.pref

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)