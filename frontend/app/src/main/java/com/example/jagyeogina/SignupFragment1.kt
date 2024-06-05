package com.example.jagyeogina

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jagyeogina.databinding.FragmentSignup1Binding

class SignupFragment1 : Fragment() {

    private var _binding: FragmentSignup1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignup1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkboxAll.setOnClickListener {
            if (!binding.checkboxAll.isChecked)
                updateAllCheckboxes(false)
        }

        binding.checkboxAll.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                updateAllCheckboxes(true)
            binding.buttonNext.isEnabled = isChecked
        }

        binding.checkbox1.setOnClickListener { binding.checkboxAll.isChecked = isAllChecked() }
        binding.checkbox2.setOnClickListener { binding.checkboxAll.isChecked = isAllChecked() }
        binding.checkbox3.setOnClickListener { binding.checkboxAll.isChecked = isAllChecked() }

        binding.buttonNext.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SignupFragment2())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateAllCheckboxes(isChecked: Boolean) {
        binding.checkbox1.isChecked = isChecked
        binding.checkbox2.isChecked = isChecked
        binding.checkbox3.isChecked = isChecked
    }
    private fun isAllChecked(): Boolean {
        return binding.checkbox1.isChecked && binding.checkbox2.isChecked && binding.checkbox3.isChecked
    }
}