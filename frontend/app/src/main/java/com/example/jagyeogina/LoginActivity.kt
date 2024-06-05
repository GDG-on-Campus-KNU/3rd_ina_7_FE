package com.example.jagyeogina

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.jagyeogina.databinding.ActivityLoginBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container_view, LoginFragment())
            }
        }

        // 빈 곳 터치 시 포커스 해제
        binding.root.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                currentFocus?.let { view ->
                    view.clearFocus()
                    hideKeyboard(view)
                }
            }
            false
        }

        // 뒤로 가기 버튼 눌렀을 때 포커스 해제
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentFocus?.let { view ->
                    view.clearFocus()
                    hideKeyboard(view)
                }
                if (isEnabled) {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }
    private fun hideKeyboard(view: View) {
        val windowInsetsController = ViewCompat.getWindowInsetsController(view)
        windowInsetsController?.hide(WindowInsetsCompat.Type.ime())
    }
}
