package com.example.jagyeongina.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jagyeongina.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    lateinit var binding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            // 사용자 프로필 수정
            profileBox.setOnClickListener {
                startActivity(Intent(binding.root.context,ProfileModifyActivity::class.java))
            }
            profileBtn.setOnClickListener {
                startActivity(Intent(binding.root.context,ProfileModifyActivity::class.java))
            }
        }
    }
}