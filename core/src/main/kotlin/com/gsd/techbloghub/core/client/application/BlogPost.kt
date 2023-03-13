package com.gsd.techbloghub.core.client.application

import java.time.LocalDate

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 * 모든 포스팅 크롤링용 DTO는 이 인터페이스를 구현해야 한다.
 **/
interface BlogPost {

    val id: String
    val title: String
    val link: String
    val postDate: LocalDate


    fun toBlogContent(platformVendor: PlatformVendor): BlogContent
}