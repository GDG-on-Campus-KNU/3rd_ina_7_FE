package com.example.jagyeogina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jagyeogina.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            // 로그인 버튼 클릭 시 동작할 코드를 여기에 작성
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            // 여기에서 로그인 로직을 처리하거나, ViewModel을 사용하여 처리할 수 있습니다.
        }
    }
}
