package com.example.jagyeongina.ui.guest_home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jagyeongina.databinding.FragmentGuestHomeBinding
import com.example.jagyeongina.model.Certificate
import com.example.jagyeongina.ui.adapter.CertificatesAdapter

class GuestHomeFragment : Fragment() {
    lateinit var binding: FragmentGuestHomeBinding
//    private val myBookmarksViewModel: MyBookmarksViewModel by viewModels()
    var popularCertis = mutableListOf(
        Certificate(0,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,false),
        Certificate(1,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,false),
        Certificate(2,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,true),
        Certificate(3,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,true),
    )
    var ageCertis = mutableListOf(
        Certificate(0,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,false),
        Certificate(1,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,false),
        Certificate(2,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,true),
        Certificate(3,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,true),
    )
    var recommandCertis = mutableListOf(
        Certificate(0,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,false),
        Certificate(1,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,false),
        Certificate(2,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,true),
        Certificate(3,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,true),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuestHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setUi()
    }

    private fun setAdapter() {
        // 인기 자격증 Adapter 설정
        val popularCertiAdapter = CertificatesAdapter()
        popularCertiAdapter.detailCertificateListener =
            object : CertificatesAdapter.DetailCertificateListener {
                override fun onClick(certificate: Certificate) {
                    // 자격증 자세히 보기로 이동

                }
            }
        // RecyclerView 설정
        binding.popularCertiRv.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularCertiAdapter
        }
        // RecyclerView Item 설정
        popularCertiAdapter.submitList(popularCertis)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }

        // 나이별 인기 자격증 Adapter 설정
        val ageCertiAdapter = CertificatesAdapter()
        ageCertiAdapter.detailCertificateListener =
            object : CertificatesAdapter.DetailCertificateListener {
                override fun onClick(certificate: Certificate) {
                    // 자격증 자세히 보기로 이동

                }
            }
        // RecyclerView 설정
        binding.ageCertiRv.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ageCertiAdapter
        }
        // RecyclerView Item 설정
        ageCertiAdapter.submitList(ageCertis)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }

        // 추천 자격증 Adapter 설정
        val recommandCertiAdapter = CertificatesAdapter()
        recommandCertiAdapter.detailCertificateListener =
            object : CertificatesAdapter.DetailCertificateListener {
                override fun onClick(certificate: Certificate) {
                    // 자격증 자세히 보기로 이동

                }
            }
        // RecyclerView 설정
        binding.recommandCertiRv.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = recommandCertiAdapter
        }
        // RecyclerView Item 설정
        recommandCertiAdapter.submitList(recommandCertis)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }
    }

    private fun setUi() {
        binding.apply {

        }
    }
}