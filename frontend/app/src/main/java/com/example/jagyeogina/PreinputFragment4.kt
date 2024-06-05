package com.example.jagyeogina

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.jagyeogina.databinding.FragmentPreinput3Binding
import com.example.jagyeogina.databinding.FragmentPreinput4Binding

class PreinputFragment4 : Fragment() {

    private var _binding: FragmentPreinput4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreinput4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSpinners()

        binding.buttonNext.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    private fun setSpinners() {
        val educationArray = resources.getStringArray(R.array.education)
        val educationAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, educationArray)
        val enrollmentArray = resources.getStringArray(R.array.enrollment)
        val enrollmentAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, enrollmentArray)
        val gradeArray = resources.getStringArray(R.array.grade)
        val gradeAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, gradeArray)
        val yearArray = resources.getStringArray(R.array.graduation_year)
        val yearAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, yearArray)
        binding.textviewEducation.setAdapter(educationAdapter)
        binding.textviewEnrollment.setAdapter(enrollmentAdapter)
        binding.textviewGrade.setAdapter(gradeAdapter)
        binding.textviewYear.setAdapter(yearAdapter)
    }
}