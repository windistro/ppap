package com.example.ppaps.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.ppaps.R
import com.example.ppaps.databinding.FragmentCameraBinding
import com.example.ppaps.databinding.FragmentHomeBinding

class CameraFragment : Fragment() {
    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val gradientDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.gradient_bg)
        view?.background = gradientDrawable

        return binding.root
    }
}