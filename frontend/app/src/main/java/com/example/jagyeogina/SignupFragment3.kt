package com.example.jagyeogina

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.jagyeogina.databinding.FragmentSignup2Binding
import com.example.jagyeogina.databinding.FragmentSignup3Binding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

class SignupFragment3 : Fragment() {

    private var _binding: FragmentSignup3Binding? = null
    private val binding get() = _binding!!
    private val viewModel: SignupViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignup3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner()

        binding.edittextNickname.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val nickname = binding.edittextNickname.text?.toString()?.trim() // edittext에 아무것도 없으면 null 반환
                if (nickname.isNullOrEmpty()) {
                    binding.textviewErrorNickname.text = "닉네임을 입력해주세요."
                    changeRed(binding.edittextNickname, binding.textviewErrorNickname)
                } else {
                    viewModel.setNickname(nickname)
                    changeWhite(binding.edittextNickname, binding.textviewErrorNickname)
                }
                validateInputs()
            }
        }

        binding.buttonNicknameCheck.setOnClickListener {
            val nickname = binding.edittextNickname.text?.toString()?.trim() // edittext에 아무것도 없으면 null 반환
            if (nickname.isNullOrEmpty()) {
                binding.textviewErrorNickname.text = "닉네임을 입력해주세요."
                changeRed(binding.edittextNickname, binding.textviewErrorNickname)
            } else {
                // 닉네임 중복 검사 api 호출
                // if (중복)
                binding.textviewErrorNickname.text = "중복되는 닉네임입니다."
                changeRed(binding.edittextNickname, binding.textviewErrorNickname)
                // else
                // binding.textviewErrorNickname.visibility = View.INVISIBLE
                viewModel.setNicknameValidation(nickname)
            }
            validateInputs()
        }

        binding.edittextYear.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateInputs()
            }
        }

        binding.edittextDate.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateInputs()
            }
        }

        binding.buttonNext.setOnClickListener {
            // 회원 가입 api
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setSpinner()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setSpinner() {
        val regionArray = resources.getStringArray(R.array.months_array)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, regionArray)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            validateInputs()
        }
    }


    private fun changeRed(editText: EditText, textviewError: TextView) {
        editText.background = ContextCompat.getDrawable(requireContext(),
            R.drawable.white_square_red_stroke
        )
        textviewError.visibility = View.VISIBLE
    }

    private fun changeWhite(editText: EditText, textviewError: TextView) {
        editText.background = ContextCompat.getDrawable(requireContext(),
            R.drawable.bg_edittext
        )
        textviewError.visibility = View.INVISIBLE
    }

    private fun validateInputs() {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val year = binding.edittextYear.text.toString().trim().toIntOrNull()
        val monthString = binding.autoCompleteTextView.text.toString().replace("월", "").trim()
        val month = monthString.toIntOrNull()
        val date = binding.edittextDate.text.toString().trim().toIntOrNull()

        val isNicknameValid = viewModel.nickname.value?.let { it == viewModel.nicknameValidation.value } ?: false
        var isBirthDateValid = false

        val isYearValid = year != null && year > currentYear

        val isDateMissing = year != null && month != null && date == null

        if (year != null && month != null && date != null) {
            val isLeapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
            val maxDaysInMonth = when (month) {
                2 -> if (isLeapYear) 29 else 28
                4, 6, 9, 11 -> 30
                else -> 31
            }
            isBirthDateValid = date in 1..maxDaysInMonth
        }

        if (isYearValid) {
            changeRed(binding.edittextYear, binding.textviewErrorBirthdate)
        } else {
            changeWhite(binding.edittextYear, binding.textviewErrorBirthdate)
        }

        if (isDateMissing || !isBirthDateValid) {
            changeRed(binding.edittextDate, binding.textviewErrorBirthdate)
        } else {
            changeWhite(binding.edittextDate, binding.textviewErrorBirthdate)
        }

        binding.buttonNext.isEnabled = isNicknameValid && !isYearValid && !isDateMissing && isBirthDateValid
    }
}