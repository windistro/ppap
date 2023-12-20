package com.example.myambulance.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myambulance.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneNumberTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var iv_user: ImageView
    private lateinit var btn_edit_profile: Button
    private lateinit var button_about: Button
    private lateinit var button_feedback: Button
    private lateinit var button_setting: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usernameTextView = view.findViewById(R.id.usernameTextView)
        emailTextView = view.findViewById(R.id.emailTextView)
        phoneNumberTextView = view.findViewById(R.id.phoneNumberTextView)
        addressTextView = view.findViewById(R.id.addressTextView)
        iv_user = view.findViewById(R.id.iv_user)
        btn_edit_profile = view.findViewById(R.id.btn_edit_profile)
        button_about = view.findViewById(R.id.button_about)
        button_feedback = view.findViewById(R.id.button_feedback)
        button_setting = view.findViewById(R.id.button_setting)


        val username = "Shanna Shannon"
        val email = "shanna@example.com"
        val phoneNumber = "081547659891"
        val address = "jl. Setiabudhi, Kota Jember"
        val userImage = R.drawable.photos

        // Set data ke tampilan
        usernameTextView.text = username
        emailTextView.text = email
        phoneNumberTextView.text = phoneNumber
        addressTextView.text = address
        Glide.with(requireContext())
            .load(userImage)
            .into(iv_user)


        btn_edit_profile.setOnClickListener {
        }

        button_about.setOnClickListener {
        }

        button_feedback.setOnClickListener {
        }

        button_setting.setOnClickListener {
        }
    }
}
