package com.example.jagyeogina

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jagyeogina.databinding.FragmentPreinput1Binding
import com.example.jagyeogina.databinding.FragmentPreinput3Binding

class PreinputFragment3 : Fragment() {

    private var _binding: FragmentPreinput3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreinput3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, PreinputFragment4())
                .addToBackStack(null)
                .commit()
        }
    }
}