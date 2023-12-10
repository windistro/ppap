package com.example.ppaps.ui.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ppaps.R
import com.example.ppaps.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}