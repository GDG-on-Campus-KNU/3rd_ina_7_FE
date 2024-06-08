package com.example.jagyeogina.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jagyeongina.R
import com.example.jagyeongina.databinding.ActivityMainBinding
import com.example.jagyeongina.ui.calendar.CalendarFragment
import com.example.jagyeongina.ui.community.CommunityFragment
import com.example.jagyeongina.ui.guest_home.GuestHomeFragment
import com.example.jagyeongina.ui.mypage.MypageFragment
import com.example.jagyeongina.ui.search.SearchFragment
import com.example.jagyeongina.ui.user_home.UserHomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()
    }

    private fun setUi() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, GuestHomeFragment()).commit()
        binding.bnv.setOnItemSelectedListener {item ->
            val transaction = supportFragmentManager.beginTransaction()
            when(item.itemId) {
                R.id.fragment_home -> transaction.replace(R.id.fragment_container, UserHomeFragment())
                R.id.fragment_search -> transaction.replace(R.id.fragment_container, SearchFragment())
                R.id.fragment_calendar -> transaction.replace(R.id.fragment_container, CalendarFragment())
                R.id.fragment_community -> transaction.replace(R.id.fragment_container, CommunityFragment())
                R.id.fragment_mypage -> transaction.replace(R.id.fragment_container, MypageFragment())
            }
            transaction.commit()
            true
        }
    }
}