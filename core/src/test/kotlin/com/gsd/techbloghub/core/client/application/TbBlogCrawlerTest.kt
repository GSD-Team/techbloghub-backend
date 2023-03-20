package com.gsd.techbloghub.core.client.application

import com.gsd.techbloghub.core.client.application.component.TbBlogCrawler
import com.gsd.techbloghub.core.client.application.interfaces.BlogContent
import com.gsd.techbloghub.core.client.application.interfaces.BlogPost
import com.gsd.techbloghub.core.client.application.interfaces.BlogContents
import com.gsd.techbloghub.core.client.application.interfaces.PlatformVendor
import org.assertj.core.api.AssertionsForInterfaceTypes.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 **/
class TbBlogCrawlerTest {


    @Test
    @DisplayName("새로운 포스트만 가져오기")
    fun scrapNewPosts() {
        //given
        val lastId = "50"
        //when
        val scrapNewPosts: BlogContents = TbBlogCrawler.scrapNewPosts(
            scrapFunction = { page -> mockScrap(page) },
            firstPage = 0,
            lastScrapId = lastId,
            platformVendor = PlatformVendor(
                id = 1L,
                name = "test",
                thumbnailURL = null,
            ),
        )

        val lastScrapId = scrapNewPosts.lastScrapId
        //then 마지막으로 스크랩한 시퀀스가 50이니, 49까지만 스크랩한다.
        assertThat(lastScrapId).isEqualTo("49")
    }

    private fun mockScrap(page: Int): List<BlogPost> {
        val scrapList: MutableList<MockBlogPost> = mutableListOf()
        for (i in 0..10) {
            val id = (page * 10 + i).toString()
            val title = "title $id"
            val link = "link $id"
            val postDate = LocalDate.now()
            val excerpt = "excerpt $id"
            scrapList.add(MockBlogPost(id, title, link, postDate, excerpt))
        }
        return scrapList

    }

    class MockBlogPost(
        override val id: String,
        override val title: String,
        override val link: String,
        override val postDate: LocalDate,
        override val excerpt: String
    ) : BlogPost {
        override fun toBlogContent(platformVendor: PlatformVendor): BlogContent {
            return BlogContent.of(this, platformVendor)
        }

    }
}