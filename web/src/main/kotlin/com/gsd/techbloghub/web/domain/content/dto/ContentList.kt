package com.gsd.techbloghub.web.domain.content.dto

import com.gsd.techbloghub.core.client.application.interfaces.BlogContent
import com.gsd.techbloghub.core.client.application.interfaces.PlatformVendor
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/
class ContentList(
    val lastId: Long?,
    val blogContents: List<BlogContent>
) {

    companion object {
        fun mock(search: ContentSearch): ContentList {
            val blogContents = mutableListOf<BlogContent>()
            val randomList = listOf(
                BlogContent(
                    title = "Spark on Kubernetes로 이관하기",
                    link = "https://techblog.woowahan.com/10291/",
                    thumbnailURL = null,
                    excerpt = "",
                    platformVendor = PlatformVendor(
                        1L,
                        "우아한형제들",
                        "https://techblog.woowahan.com/wp-content/uploads/2021/04/logo-e1619937994625.png"
                    ),
                    postDate = LocalDate.now(),
                    scrapDate = LocalDateTime.now(),
                    id = ""
                ),
                BlogContent(
                    title = "모던 프론트엔드 프로젝트 구성 기법 - 모노레포 도구 편",
                    link = "https://d2.naver.com/helloworld/7553804",
                    thumbnailURL = "https://d2.naver.com/content/images/2022/04/----.png",
                    excerpt = "이 글에서는 모노레포 개념 편에 이어 Yarn, Lerna, Nx 그리고 Turborepo 도구에 대해 자세히 소개해 드리려고 합니다. Yarn Lerna Nx Turborepo 1. Yarn Yarn 1.x https://classic.yarnpkg.com/en/docs/cli/ Yarn(1.x) 또는 npm(7.x)의 workspaces 필드를 사용해 간단히 모노레포를 구성할 수 있다. yarn link 또는 npm link 기능을 선언적으",
                    platformVendor = PlatformVendor(
                        2L,
                        "네이버 D2",
                        "https://d2.naver.com/static/img/app/d2_logo.gif"
                    ),
                    postDate = LocalDate.now(),
                    scrapDate = LocalDateTime.now(),
                    id = ""
                ),
                BlogContent(
                    title = "전자증명서 리액트 페이지 및 레이어 동적 라우팅",
                    link = "https://tech.kakao.com/2022/07/13/active-routing-for-e-certificate/",
                    thumbnailURL = null,
                    excerpt = "전자증명서 프로젝트란 카카오톡에서 주민등록등본과 같은 증명서를 발급받고 해당 증명서를 직접 방문이 아닌 카카오톡에서 기관에 손쉽게 제출할 수 있도록 도와주는 서비스입니다. 프로젝트는 React로 개발하였으며 react-router를 통해 페이지,",
                    platformVendor = PlatformVendor(
                        3L,
                        "카카오",
                        "https://tech.kakao.com/wp-content/uploads/2022/02/kakao-tech-logo-1-e1649831117387.png"
                    ),
                    postDate = LocalDate.now(),
                    scrapDate = LocalDateTime.now(),
                    id = ""
                ),
            )

            for (i in 1..search.pageSize!!) {
                blogContents.add(randomList[(0..2).random()])
            }
            return ContentList(
                lastId = search.currentNextId!! + search.pageSize,
                blogContents = blogContents
            )
        }
    }
}