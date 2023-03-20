package com.gsd.techbloghub.web.scheduler

import com.gsd.techbloghub.core.client.application.component.TbBlogCrawler
import com.gsd.techbloghub.core.client.application.interfaces.BlogPost
import com.gsd.techbloghub.core.client.application.interfaces.BlogContents
import com.gsd.techbloghub.core.client.kakao.KakaoTbClient
import com.gsd.techbloghub.core.client.naver.NaverTbClient
import com.gsd.techbloghub.core.client.woowahan.WoowahanTbClient
import com.gsd.techbloghub.core.client.woowahan.http.WoowahanTbRequest
import com.gsd.techbloghub.core.constant.VendorCode
import com.gsd.techbloghub.domain.content.constant.ContentType
import com.gsd.techbloghub.web.domain.content.dto.vendor.VendorDto
import com.gsd.techbloghub.web.domain.content.service.ContentScrapService
import com.gsd.techbloghub.web.domain.content.service.VendorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2023/03/17.
 **/

@Component
class BlogScrapScheduler @Autowired constructor(
    private val naverTbClient: NaverTbClient,
    private val kakaoTbClient: KakaoTbClient,
    private val woowahanTbClient: WoowahanTbClient,
    private val vendorService: VendorService,
    private val contentScrapService: ContentScrapService,
) {

    companion object {
        const val FIXED_DELAY: Long = 1000 * 60 * 60 //1시간
    }

    //네이버
    @Scheduled(fixedDelay = FIXED_DELAY)
    fun naver() {
        val vendorCode = VendorCode.NAVER
        val firstPage = 0
        scrapBlog(vendorCode, firstPage) { page -> naverTbClient.getPosts(page = page).contents }
    }

    //카카오
    @Scheduled(fixedDelay = FIXED_DELAY)
    fun kakao() {
        val vendorCode = VendorCode.KAKAO
        val firstPage = 1
        scrapBlog(vendorCode, firstPage) { page -> kakaoTbClient.getList(page = page) }
    }


    //우형
    @Scheduled(fixedDelay = FIXED_DELAY)
    fun woowahan() {
        val vendorCode = VendorCode.WOOWAHAN
        val firstPage = 1
        scrapBlog(vendorCode, firstPage) { page ->
            woowahanTbClient.getPosts(WoowahanTbRequest.from(page))
                .data
                .posts
        }
    }

    private fun scrapBlog(vendorCode: VendorCode, firstPage: Int, scrapFunction: (Int) -> List<BlogPost>) {
        val vendor = getVendor(vendorCode)
        val lastScrap = vendorService.getLastScrap(vendorCode, ContentType.BLOG)
        val scrapNewPosts: BlogContents = TbBlogCrawler.scrapNewPosts(
            scrapFunction = scrapFunction,
            firstPage = firstPage,
            lastScrapId = lastScrap.lastContentSeq,
            platformVendor = vendor.toPlatformVendor(),
        )
        if (scrapNewPosts.existNewPost) {
            addPosts(vendorCode, scrapNewPosts)
        }
    }


    private fun addPosts(vendorCode: VendorCode, posts: BlogContents) {
        contentScrapService.addAll(vendorCode, posts.contents)
        vendorService.completeScrap(vendorCode, posts)
    }

    private fun getVendor(vendorCode: VendorCode): VendorDto {
        return vendorService.getVendor(vendorCode)
    }

}