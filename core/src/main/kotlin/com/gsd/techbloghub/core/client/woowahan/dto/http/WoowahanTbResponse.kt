package com.gsd.techbloghub.core.client.woowahan.dto.http

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/02/09.
 **/
class WoowahanTbResponse(
    val success: Boolean,
    val data: Data
) {


    class Data(
        @JsonProperty("posts")
        val posts: List<Post>,
        @JsonProperty("length")
        val totalCount: Long,
        @JsonProperty("pagination")
        val pagination: Pagination,
    ) {

    }

    class Pagination(
        @JsonProperty("current")
        val currentPage: Int,
        @JsonProperty("per")
        val pageSize: Int,
        @JsonProperty("max")
        val pageCount: Int
    )

    class Post(
        @JsonProperty("post")
        val detail: PostDetail,
        @JsonProperty("excerpt")
        val excerpt: String, //발췌
        @JsonProperty("permalink")
        val link: String, //상세페이지 링크
    ) {
    }


    class PostDetail(
        @JsonProperty("ID")
        val id: Long, //포스트 시퀀스
        @JsonProperty("post_author")
        val authorId: String, //작성자 시퀀스
        @JsonProperty("post_date")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        val postDate: LocalDateTime, //작성일
        @JsonProperty("post_title")
        val title: String, //제목
        @JsonProperty("post_content")
        val content: String, //내용
        @JsonProperty("post_modified")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        val modifedDate: LocalDateTime, //수정일
    ) {

    }
}