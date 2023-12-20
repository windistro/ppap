package com.example.ppaps.ui.main.emergency

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.ppaps.R
import com.example.ppaps.databinding.FragmentEmergencyBinding
import com.example.ppaps.databinding.FragmentEmergencyResultBinding

class EmergencyResultFragment : Fragment() {
    private var _binding: FragmentEmergencyResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmergencyResultBinding.inflate(layoutInflater, container, false)
        val gradientDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.gradient_bg)
        view?.background = gradientDrawable
        return binding.root
    }
}