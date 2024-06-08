package com.example.jagyeongina.ui.user_home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jagyeogina.ui.CertiDetailActivity
import com.example.jagyeongina.ApplicationClass
import com.example.jagyeongina.databinding.FragmentUserHomeBinding
import com.example.jagyeongina.model.Certificate
import com.example.jagyeongina.ui.adapter.CertificatesAdapter

class UserHomeFragment : Fragment() {
    lateinit var binding: FragmentUserHomeBinding
    //    private val myBookmarksViewModel: MyBookmarksViewModel by viewModels()
    var interestCertis = mutableListOf(
        Certificate(0,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,false),
        Certificate(1,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,false),
        Certificate(2,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,true),
        Certificate(3,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,true),
    )
    var hopeCertis = mutableListOf(
        Certificate(0,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,false),
        Certificate(1,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,false),
        Certificate(2,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",true,true),
        Certificate(3,"산업안전지도사","14회 1차 2024.03.30.","한국산업인력공단","국가전문자젹","고용노동부",false,true),
    )
    var majorCertis = mutableListOf(
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
        binding = FragmentUserHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setUi()
    }

    private fun setAdapter() {
        // 관심사별 자격증 Adapter 설정
        val interestCertiAdapter = CertificatesAdapter()
        interestCertiAdapter.detailCertificateListener =
            object : CertificatesAdapter.DetailCertificateListener {
                override fun onClick(certificate: Certificate) {
                    // 자격증 자세히 보기로 이동
                    val intent = Intent(this@UserHomeFragment.context, CertiDetailActivity::class.java)
                    intent.putExtra(ApplicationClass.CERTI_ITEM, certificate)
                    startActivity(intent)
                }
            }
        // RecyclerView 설정
        binding.interestCertiRv.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = interestCertiAdapter
        }
        // RecyclerView Item 설정
        interestCertiAdapter.submitList(interestCertis)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }

        // 희망 직업별 인기 자격증 Adapter 설정
        val hopeCertiAdapter = CertificatesAdapter()
        hopeCertiAdapter.detailCertificateListener =
            object : CertificatesAdapter.DetailCertificateListener {
                override fun onClick(certificate: Certificate) {
                    // 자격증 자세히 보기로 이동
                    val intent = Intent(this@UserHomeFragment.context, CertiDetailActivity::class.java)
                    intent.putExtra(ApplicationClass.CERTI_ITEM, certificate)
                    startActivity(intent)
                }
            }
        // RecyclerView 설정
        binding.hopeCertiRv.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = hopeCertiAdapter
        }
        // RecyclerView Item 설정
        hopeCertiAdapter.submitList(hopeCertis)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }

        // 전공별 자격증 Adapter 설정
        val majorCertiAdapter = CertificatesAdapter()
        majorCertiAdapter.detailCertificateListener =
            object : CertificatesAdapter.DetailCertificateListener {
                override fun onClick(certificate: Certificate) {
                    // 자격증 자세히 보기로 이동
                    val intent = Intent(this@UserHomeFragment.context, CertiDetailActivity::class.java)
                    intent.putExtra(ApplicationClass.CERTI_ITEM, certificate)
                    startActivity(intent)
                }
            }
        // RecyclerView 설정
        binding.majorCertiRv.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = majorCertiAdapter
        }
        // RecyclerView Item 설정
        majorCertiAdapter.submitList(majorCertis)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }
    }

    private fun setUi() {
        binding.apply {

        }
    }
}