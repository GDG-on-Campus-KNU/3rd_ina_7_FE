package com.example.jagyeongina.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jagyeongina.databinding.FragmentCommunityBinding
import com.example.jagyeongina.model.Board
import com.example.jagyeongina.model.Certificate
import com.example.jagyeongina.ui.adapter.BoardsAdapter
import com.example.jagyeongina.ui.adapter.CertificatesAdapter

class CommunityFragment : Fragment() {
    lateinit var binding: FragmentCommunityBinding
    //    private val myBookmarksViewModel: MyBookmarksViewModel by viewModels()
    var boards = mutableListOf(
        Board(0,"모집중","정기","대구","산안기 노베 스터디원 모집합니다","#산업안전기사 #주1회 #온라인가능 #휴학", "05.05. 19:28", false, 1),
        Board(1,"모집중","정기","대구","산안기 노베 스터디원 모집합니다","#산업안전기사 #주1회 #온라인가능 #휴학", "05.08. 16:30", false, 0),
        Board(2,"모집중","정기","대구","산안기 노베 스터디원 모집합니다","#산업안전기사 #주1회 #온라인가능 #휴학", "05.10. 20:53", false, 10),
        Board(3,"모집중","정기","대구","산안기 노베 스터디원 모집합니다","#산업안전기사 #주1회 #온라인가능 #휴학", "05.14. 08:17", false, 20),
        Board(4,"모집중","정기","대구","산안기 노베 스터디원 모집합니다","#산업안전기사 #주1회 #온라인가능 #휴학", "05.15. 11:46", false, 7),
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setUi()
    }

    private fun setAdapter() {
        // 스터디 게시글 Adapter 설정
        val boardsAdapter = BoardsAdapter()
        boardsAdapter.detailBoardListener =
            object : BoardsAdapter.DetailBoardListener {
                override fun onClick(board: Board) {
                    // 스터디 게시글 자세히 보기로 이동

                }
            }
        // RecyclerView 설정
        binding.boardRv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = boardsAdapter
        }
        // RecyclerView Item 설정
        boardsAdapter.submitList(boards)
//        myBookmarksViewModel.myCourses.observe(this) {
//            courseAdapter.submitList(it)
//        }
    }

    private fun setUi() {
        binding.apply {
            // 게시글 작성 버튼
            boardWriteBtn.setOnClickListener {

            }
            // 게시글 검색 버튼
            searchBtn.setOnClickListener {

            }
        }
    }
}