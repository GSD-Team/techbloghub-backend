package com.gsd.techbloghub.core.client.application.component

import com.gsd.techbloghub.core.client.application.interfaces.BlogContent
import com.gsd.techbloghub.core.client.application.interfaces.BlogPost
import com.gsd.techbloghub.core.client.application.interfaces.BlogContents
import com.gsd.techbloghub.core.client.application.interfaces.PlatformVendor

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/
object TbBlogCrawler {

    /**
     * 새로운 포스트를 스크랩합니다.
     * 마지막으로 스크랩한 포스트의 시퀀스와 같은 포스트가 나오면 중단합니다.
     * @param scrapFunction 포스트 스크랩핑 함수
     * @param firstPage 첫페이지 기준(보통 0또는 1)
     * @param lastScrapId 마지막 스크랩한 포스트의 시퀀스
     * @param platformVendor 플랫폼 벤더사정보
     * @return List<BlogContent> 새로운 포스트 리스트
     */
    fun scrapNewPosts(
        scrapFunction: (page: Int) -> List<BlogPost>,
        firstPage: Int,
        lastScrapId: String?,
        platformVendor: PlatformVendor,
    ): BlogContents {
        val blogContents = mutableListOf<BlogContent>()
        var page = firstPage
        var processScrap = true
        while (processScrap) {
            //포스트 스크랩핑 함수 실행.
            val blogPosts = scrapFunction(page)
            if (blogPosts.isEmpty()) { //스크랩한 포스트가 없으면 중단
                processScrap = false
                break;
            }
            for (blogPost in blogPosts) {
                if (blogPost.id == lastScrapId) { //마지막으로 스크랩한 포스트의 시퀀스가 동일하면 중단
                    processScrap = false
                    break;
                }
                blogContents.add(blogPost.toBlogContent(platformVendor))
            }
            page++;
        }

        return BlogContents.from(blogContents.toList())
    }
}