package com.example.jagyeogina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jagyeogina.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener {
            var id = binding.edittextId.text
            var pw = binding.edittextPw.text
            //로그인 후 mainActivity로 intent
            val intent = Intent(requireContext(), PreinputActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        binding.textviewFindId.setOnClickListener {

        }
        binding.textviewFindPw.setOnClickListener {

        }
        binding.textviewSignup.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SignupFragment1())
                .addToBackStack(null)
                .commit()
        }
        binding.buttonLoginNaver.setOnClickListener { 
            //소셜 로그인 -네이버
        }
        binding.buttonLoginKakao.setOnClickListener {
            //소셜 로그인 -카카오
        }
        binding.buttonLoginGoogle.setOnClickListener {
            //소셜 로그인 -구글
        }
        binding.buttonGuest.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}