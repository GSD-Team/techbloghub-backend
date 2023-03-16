package com.gsd.techbloghub.core.client.woowahan.http

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.gsd.techbloghub.core.client.application.BlogPost
import com.gsd.techbloghub.core.client.application.BlogContent
import com.gsd.techbloghub.core.client.application.PlatformVendor
import java.time.LocalDate
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
        override val excerpt: String, //발췌
        @JsonProperty("permalink")
        override val link: String, //상세페이지 링크
    ) : BlogPost {

        override val id: String
            get() = detail.id

        override val title: String
            get() = detail.title

        override val postDate: LocalDate
            get() = detail.postDate

        override fun toBlogContent(platformVendor: PlatformVendor): BlogContent {
            return BlogContent(
                title = title,
                link = link,
                excerpt = excerpt,
                postDate = postDate,
                scrapDate = LocalDateTime.now(),
                platformVendor = platformVendor
            )
        }
    }


    class PostDetail(
        @JsonProperty("ID")
        val id: String, //포스트 시퀀스
        @JsonProperty("post_author")
        val authorId: String, //작성자 시퀀스
        @JsonProperty("post_date")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        val postDateTime: LocalDateTime, //작성일
        @JsonProperty("post_title")
        val title: String, //제목
        @JsonProperty("post_content")
        val content: String, //내용
        @JsonProperty("post_modified")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        val modifedDate: LocalDateTime, //수정일
    ) {

        val postDate: LocalDate
            get() = postDateTime.toLocalDate()

    }

}