package com.example.jagyeogina.ui.user_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jagyeogina.databinding.FragmentGuestHomeBinding
import com.example.jagyeogina.databinding.FragmentUserHomeBinding

class UserHomeFragment : Fragment() {
    lateinit var binding: FragmentUserHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()
    }

    private fun setUi() {
        binding.apply {

        }
    }
}