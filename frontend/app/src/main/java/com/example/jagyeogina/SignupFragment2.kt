package com.example.jagyeogina

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.jagyeogina.databinding.FragmentSignup2Binding

class SignupFragment2 : Fragment() {

    private var _binding: FragmentSignup2Binding? = null
    private val binding get() = _binding!!
    private val viewModel: SignupViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignup2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edittextId.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val id = binding.edittextId.text?.toString()?.trim() // edittext에 아무것도 없으면 null 반환
                if (id.isNullOrEmpty()) {
                    binding.textviewErrorId.text = "아이디를 입력해주세요."
                    changeRed(binding.edittextId, binding.textviewErrorId)
                } else {
                    viewModel.setId(id)
                    changeWhite(binding.edittextId, binding.textviewErrorId)
                }
                validateInputs()
            }
        }

        binding.buttonIdCheck.setOnClickListener {
            val id = binding.edittextId.text?.toString()?.trim() // edittext에 아무것도 없으면 null 반환
            if (id.isNullOrEmpty()) {
                binding.textviewErrorId.text = "아이디를 입력해주세요."
                changeRed(binding.edittextId, binding.textviewErrorId)
            } else {
                // id 중복 검사 api 호출
                // if (중복)
                binding.textviewErrorId.text = "중복되는 아이디입니다."
                changeRed(binding.edittextId, binding.textviewErrorId)
                // else
                // binding.textviewErrorId.visibility = View.INVISIBLE
                viewModel.setIdValidation(id)
            }
            validateInputs()
        }
        
        binding.edittextPw.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val pw = binding.edittextPw.text?.toString()?.trim() // edittext에 아무것도 없으면 null 반환
                if (pw.isNullOrEmpty()) {
                    binding.textviewErrorPw.text = "비밀번호를 입력해주세요."
                    changeRed(binding.edittextPw, binding.textviewErrorPw)
                } else {
                    viewModel.setPassword(pw)
                    changeWhite(binding.edittextPw, binding.textviewErrorPw)
                }
                validateInputs()
            }
        }

        binding.edittextPwCheck.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val pw = binding.edittextPw.text?.toString()?.trim()            // edittext에 아무것도 없으면 null 반환
                val pwCheck = binding.edittextPwCheck.text?.toString()?.trim()  // edittext에 아무것도 없으면 null 반환
                if (pw.isNullOrEmpty()) {
                    binding.textviewErrorPw.text = "비밀번호를 입력해주세요."
                    changeRed(binding.edittextPwCheck, binding.textviewErrorPw)
                } else if (pwCheck.isNullOrEmpty()) {
                    binding.textviewErrorPw.text = "비밀번호 확인을 입력해주세요."
                    changeRed(binding.edittextPwCheck, binding.textviewErrorPw)
                } else if (pw == pwCheck) {
                    viewModel.setPwValidation(pwCheck)
                    changeWhite(binding.edittextPwCheck, binding.textviewErrorPw)
                } else {
                    binding.textviewErrorPw.text = "비밀번호가 다릅니다."
                    changeRed(binding.edittextPwCheck, binding.textviewErrorPw)
                }
                validateInputs()
            }
        }

        binding.edittextEmail.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val email =  binding.edittextEmail.text?.toString()?.trim()
                if (email.isNullOrEmpty()) {
                    binding.textviewErrorEmail.text = "이메일을 입력해주세요."
                    changeRed(binding.edittextEmail, binding.textviewErrorEmail)
                } else {
                    viewModel.setEmail(email)
                    changeWhite(binding.edittextEmail, binding.textviewErrorEmail)
                }
                validateInputs()
            }
        }

        binding.buttonEmailCheck.setOnClickListener {
            val email =  binding.edittextEmail.text?.toString()?.trim()
            if (email.isNullOrEmpty()) {
                binding.textviewErrorEmail.text = "이메일을 입력해주세요."
                changeRed(binding.edittextEmail, binding.textviewErrorEmail)
            } else {
                // 이메일 인증 api 호출
                // if (success)
                viewModel.setEmailValidation(email)
                changeWhite(binding.edittextEmail, binding.textviewErrorEmail)
                // else
                // binding.textviewErrorEmail.text = "이메일 인증에 실패했습니다."
                // changeRed(binding.edittextEmail, binding.textviewErrorEmail)
            }
            validateInputs()
        }

        binding.buttonNext.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SignupFragment3())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.edittextId.setText(viewModel.id.value)
        binding.edittextEmail.setText(viewModel.email.value)
        validateInputs()
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
        val isIdValid = viewModel.id.value?.let { it == viewModel.idValidation.value } ?: false
        val isPwValid = viewModel.password.value?.let { it == viewModel.pwValidation.value } ?: false
        val isEmailValid = viewModel.email.value?.let { it == viewModel.emailValidation.value } ?: false

        binding.buttonNext.isEnabled = isIdValid && isPwValid && isEmailValid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}