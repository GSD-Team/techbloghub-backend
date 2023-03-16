package com.gsd.techbloghub.web

import com.gsd.techbloghub.core.client.kakao.KakaoTbClient
import com.gsd.techbloghub.core.client.naver.NaverTbClient
import com.gsd.techbloghub.core.client.woowahan.WoowahanTbClient
import org.springframework.beans.factory.annotation.Autowired
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
) {

    //네이버
    fun naver() {

    }


    //카카오
    fun kakao() {

    }

    //우형
    fun woowahan() {

    }

}