package com.example.ppaps.ui.main.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.ppaps.R
import com.example.ppaps.data.ResultState
import com.example.ppaps.databinding.FragmentAccountBinding
import com.example.ppaps.databinding.FragmentChangePasswordBinding
import com.example.ppaps.ui.ViewModelFactory
import kotlinx.coroutines.launch

class ChangePasswordFragment : Fragment() {
    private var _binding: FragmentChangePasswordBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ChangePasswordViewModel> {
        ViewModelFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        val gradientDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.gradient_bg)
        view?.background = gradientDrawable
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val oldPass = binding.pwOldEditText.text.toString()
        val newPass = binding.pwNewEditText.text.toString()
        val newPassConfirm = binding.pwNewConEditText.text.toString()

        binding.btnChangepw.setOnClickListener {
            viewModel.getSession().observe(requireActivity()) {
                lifecycleScope.launch {
                    viewModel.changePassword(it.token, oldPass, newPass, newPassConfirm).observe(requireActivity()) {
                        when (it) {
                            is ResultState.Success -> {
                                AlertDialog.Builder(requireContext()).apply {
                                    setTitle("Berhasil")
                                    setMessage("Password Berhasil Diganti")
                                    setPositiveButton("Lanjut") { _, _ -> }
                                    create()
                                    show()
                                }
                                activity?.supportFragmentManager?.popBackStack()
                            }
                            is ResultState.Loading -> {  }
                            is ResultState.Error -> {
                                showToast(it.message!!)
                            }
                            else -> {}
                        }
                    }
                }
            }

            }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}