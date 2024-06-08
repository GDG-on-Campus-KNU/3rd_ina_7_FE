package com.example.jagyeongina.model

import java.io.Serializable

data class Board(
    val boardId: Long,
    val recruitState: String,
    val studyType: String,
    val studyRegion: String,
    val title: String,
    val tag: String,
    val date: String,
    val isLike: Boolean,
    val commentNum: Long,
) : Serializable
