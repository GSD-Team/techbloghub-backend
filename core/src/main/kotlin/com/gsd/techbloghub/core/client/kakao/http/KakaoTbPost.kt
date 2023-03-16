package com.gsd.techbloghub.core.client.kakao.http

import com.gsd.techbloghub.core.client.application.BlogContent
import com.gsd.techbloghub.core.client.application.BlogPost
import com.gsd.techbloghub.core.client.application.PlatformVendor
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/03/17.
 **/
class KakaoTbPost(
    override val id: String,
    override val title: String,
    override val link: String,
    override val postDate: LocalDate,
    override val excerpt: String
) : BlogPost {
    override fun toBlogContent(platformVendor: PlatformVendor): BlogContent {
        return BlogContent(
            title = title,
            link = link,
            postDate = postDate,
            platformVendor = platformVendor,
            excerpt = excerpt,
            scrapDate = LocalDateTime.now(),
        )
    }
}