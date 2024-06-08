package com.example.jagyeogina.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jagyeongina.databinding.ActivityCertiDetailBinding

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