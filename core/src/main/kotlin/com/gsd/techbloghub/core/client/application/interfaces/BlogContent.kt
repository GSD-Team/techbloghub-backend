package com.gsd.techbloghub.core.client.application.interfaces

import com.fasterxml.jackson.annotation.JsonFormat
import com.gsd.techbloghub.core.vo.DatePattern
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

class BlogContent(
    val id: String,
    val title: String,
    val link: String,
    val thumbnailURL: String? = null,
    val excerpt: String,
    val platformVendor: PlatformVendor,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.YYYY_MM_DD_STR)
    val postDate: LocalDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.YYYY_MM_DD_HH_MM_SS_STR)
    val scrapDate: LocalDateTime
) {


    companion object {
        fun of(blogPost: BlogPost, vendor: PlatformVendor): BlogContent {
            return BlogContent(
                id = blogPost.id,
                title = blogPost.title,
                link = blogPost.link,
                postDate = blogPost.postDate,
                platformVendor = vendor,
                excerpt = blogPost.excerpt,
                scrapDate = LocalDateTime.now()
            )
        }
    }
}