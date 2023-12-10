package com.example.ppaps.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ppaps.R
import com.example.ppaps.databinding.ActivitySignupBinding
import com.example.ppaps.ui.signin.SigninActivity
import com.example.ppaps.ui.verification.VerificationActivity

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        initAction()
    }

    private fun initAction() {
        binding.apply {
            btnSignup.setOnClickListener {
                val intent = Intent(this@SignupActivity, VerificationActivity::class.java)
                startActivity(intent)
            }
            btnSignin.setOnClickListener {
                val intent = Intent(this@SignupActivity, SigninActivity::class.java)
                startActivity(intent)
            }
        }
    }
}