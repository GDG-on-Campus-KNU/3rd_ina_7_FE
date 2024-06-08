package com.example.jagyeongina.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jagyeongina.R
import com.example.jagyeongina.databinding.ItemBoardBinding
import com.example.jagyeongina.model.Board

class BoardsAdapter : ListAdapter<Board, BoardsAdapter.BoardsViewHolder>(
    BoardAllDiffCallback()
) {
    private lateinit var binding: ItemBoardBinding

    inner class BoardsViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBind(board: Board) {
            binding.apply {
                recruitState.text = board.recruitState
                studyType.text = board.studyType
                studyRegion.text = board.studyRegion
                boardTitle.text = board.title
                boardTag.text = board.tag
                boardDate.text = board.date
                commentNum.text = board.commentNum.toString()
                if (board.isLike) likeBtn.setImageResource(R.drawable.like_on_icon)
                else likeBtn.setImageResource(R.drawable.like_off_icon)
                likeBtn.setOnClickListener {

                }
                root.setOnClickListener {
                    detailBoardListener.onClick(board = board)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardsViewHolder {
        binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoardsViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    interface DetailBoardListener {
        fun onClick(board: Board)
    }

    lateinit var detailBoardListener: DetailBoardListener
}

class BoardAllDiffCallback : DiffUtil.ItemCallback<Board>() {
    override fun areItemsTheSame(oldItem: Board, newItem: Board): Boolean {
        return oldItem.boardId == newItem.boardId
    }

    override fun areContentsTheSame(oldItem: Board, newItem: Board): Boolean {
        return oldItem == newItem
    }
}