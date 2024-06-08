package com.example.jagyeongina.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jagyeongina.R
import com.example.jagyeongina.databinding.ItemCertiBinding
import com.example.jagyeongina.model.Certificate

class CertificatesAdapter : ListAdapter<Certificate, CertificatesAdapter.BoardsViewHolder>(
    CertificateAllDiffCallback()
) {
    private lateinit var binding: ItemCertiBinding

    inner class BoardsViewHolder(private val binding: ItemCertiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun setBind(certificate: Certificate) {
            binding.apply {
                certiName.text = certificate.name
                certiSchedule.text = certificate.date
                certiOrg.text = certificate.organization
                certiType.text = certificate.lType + "/" + certificate.mType
                if (certificate.isBookmark) bookmarkBtn.setImageResource(R.drawable.bookmark_on_icon)
                else bookmarkBtn.setImageResource(R.drawable.bookmark_off_icon)
                bookmarkBtn.setOnClickListener {

                }
                if (certificate.isLike) likeBtn.setImageResource(R.drawable.like_on_icon)
                else likeBtn.setImageResource(R.drawable.like_off_icon)
                likeBtn.setOnClickListener {

                }
                root.setOnClickListener {
                    detailCertificateListener.onClick(certificate = certificate)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardsViewHolder {
        binding = ItemCertiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardsViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: BoardsViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailCertificateListener {
        fun onClick(certificate: Certificate)
    }

    lateinit var detailCertificateListener: DetailCertificateListener
}

class CertificateAllDiffCallback : DiffUtil.ItemCallback<Certificate>() {
    override fun areItemsTheSame(oldItem: Certificate, newItem: Certificate): Boolean {
        return oldItem.certificateId == newItem.certificateId
    }

    override fun areContentsTheSame(oldItem: Certificate, newItem: Certificate): Boolean {
        return oldItem == newItem
    }
}
