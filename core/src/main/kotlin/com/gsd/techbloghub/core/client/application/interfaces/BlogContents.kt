package com.gsd.techbloghub.core.client.application.interfaces

import java.time.LocalDate

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 **/
class BlogContents(
    val contents: List<BlogContent>,
    val lastScrapId: String?,
    val lastScrapPostDate: LocalDate?
) {

    val existNewPost: Boolean
        get() = contents.isNotEmpty()

    companion object {
        fun from(contents: List<BlogContent>): BlogContents {
            if (contents.isEmpty()) {
                return BlogContents(
                    contents = emptyList(),
                    lastScrapId = null,
                    lastScrapPostDate = null
                )
            }
            //포스팅 날짜순으로 정렬
            val sortedContents = contents
                .sortedBy { blogContent -> blogContent.postDate }
            return BlogContents(
                contents = sortedContents,
                lastScrapId = sortedContents.last().id,
                lastScrapPostDate = sortedContents.last().postDate
            )
        }
    }
}