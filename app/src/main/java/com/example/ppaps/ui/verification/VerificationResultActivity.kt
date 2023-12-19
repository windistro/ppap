package com.example.ppaps.ui.verification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ppaps.R
import com.example.ppaps.databinding.ActivityVerificationResultBinding

class VerificationResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.face_verif)
    }
}