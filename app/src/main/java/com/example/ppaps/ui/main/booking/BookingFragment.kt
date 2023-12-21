package com.example.ppaps.ui.main.booking

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import com.example.ppaps.R
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.ppaps.databinding.FragmentAccountBinding
import com.example.ppaps.databinding.FragmentBookingBinding
import com.example.ppaps.ui.ViewModelFactory
import com.example.ppaps.ui.main.account.AccountViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AccountViewModel> {
        ViewModelFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        val gradientDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.gradient_bg)
        view?.background = gradientDrawable
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.toolbar
        toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(), R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }


        binding.datePickerEditText.setOnClickListener {
            showDatePickerDialog()
        }

        binding.btnPesan.setOnClickListener{
            val name = binding.nameEditText.text.toString()
            val address = binding.addressEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val date = binding.datePickerEditText.text.toString()
            val longText = binding.longEditText.text.toString()

            if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || date.isEmpty() || longText.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simulasi pesanan berhasil
            showSuccessMessage()
        }
    }
    private fun showSuccessMessage() {
        Toast.makeText(requireContext(), "Pesanan ambulance berhasil", Toast.LENGTH_SHORT).show()

        // Clear form atau lakukan tindakan lain yang diperlukan
        binding.nameEditText.text = null
        binding.addressEditText.text = null
        binding.phoneEditText.text = null
        binding.datePickerEditText.text = null
        binding.longEditText.text = null
    }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _: DatePicker, year: Int, month: Int, day: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, day)
                binding.datePickerEditText.setText(
                    SimpleDateFormat("dd/MM/yyyy", Locale.US).format(selectedDate.time)
                )
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}