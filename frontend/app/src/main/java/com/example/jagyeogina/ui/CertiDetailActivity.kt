package com.example.jagyeogina.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jagyeogina.R
import com.example.jagyeogina.databinding.ActivityCertiDetailBinding
import com.example.jagyeogina.databinding.ActivityMainBinding
import com.example.jagyeogina.databinding.FragmentGuestHomeBinding
import com.example.jagyeogina.ui.calendar.CalendarFragment
import com.example.jagyeogina.ui.community.CommunityFragment
import com.example.jagyeogina.ui.guset_home.GuestHomeFragment
import com.example.jagyeogina.ui.mypage.MypageFragment
import com.example.jagyeogina.ui.search.SearchFragment
import com.example.jagyeogina.ui.user_home.UserHomeFragment

class CertiDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityCertiDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCertiDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }

        }
    }
}