package com.gsd.techbloghub.core.client.naver.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.gsd.techbloghub.core.client.application.BlogContent
import com.gsd.techbloghub.core.client.application.BlogPost
import com.gsd.techbloghub.core.client.application.PlatformVendor
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/02/09.
 **/
class NaverTbResponse(
    @JsonProperty("content")
    val contents: List<Content>,
    @JsonProperty("page")
    val pagingnation: Page,
) {

    class Page(
        val pageSize: Int,
        val totalElements: Int,
        val totalPages: Int,
        @JsonProperty("number")
        val page: Int, //0부터 시작
    ) {
    }

    class Content(
        @JsonProperty("postTitle")
        override val title: String,
        @JsonProperty("url")
        val url: String,
        @JsonProperty("postHtml")
        override val excerpt: String,
        @JsonProperty("postPublishedAt")
        val postTimestamp: Timestamp,
    ) : BlogPost {
        override val id: String
            get() = url
        override val link: String
            get() = "$D2_URL${url}"
        override val postDate: LocalDate
            get() = postTimestamp.toLocalDateTime().toLocalDate()

        override fun toBlogContent(platformVendor: PlatformVendor): BlogContent {
            return BlogContent(
                title = title,
                link = link,
                excerpt = excerpt,
                postDate = postDate,
                platformVendor = platformVendor,
                scrapDate = LocalDateTime.now()
            )
        }
    }

    companion object {
        const val D2_URL = "https://d2.naver.com"
    }
}