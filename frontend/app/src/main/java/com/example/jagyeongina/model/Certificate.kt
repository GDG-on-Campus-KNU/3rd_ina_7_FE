package com.example.jagyeongina.model

import java.io.Serializable

data class Certificate(
    val certificateId: Long,
    val name: String,
    val date: String,
    val organization: String,
    val lType: String,
    val mType: String,
    val isLike: Boolean,
    val isBookmark: Boolean,
) : Serializable
