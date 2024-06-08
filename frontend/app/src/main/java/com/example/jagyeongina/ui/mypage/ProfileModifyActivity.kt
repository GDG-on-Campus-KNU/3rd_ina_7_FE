package com.example.jagyeongina.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jagyeongina.databinding.ActivityProfileModifyBinding

class ProfileModifyActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileModifyBinding
//    private val profileSettingViewModel: ProfileSettingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0,0)
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }

            // 사용자 기본 정보 설정
//            profileSettingViewModel.profileInfo.observe(this@ProfileSettingActivity) {
//                // 프로필 사진 설정
//
//                // 닉네임 설정
//                nicknameSettingEt.setText(it.nickname)
//                // 이메일 설정
//                emailSettingEt.setText(it.email)
//                // 상태메세지 설정
//                statusSettingEt.setText(it.statusMessage)
//            }
        }
    }
}