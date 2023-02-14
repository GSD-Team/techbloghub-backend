package com.gsd.techbloghub.web

import com.gsd.techbloghub.core.client.kakao.KakaoTbClient
import com.gsd.techbloghub.core.client.naver.NaverTbClient
import com.gsd.techbloghub.core.client.woowahan.WoowahanTbClient
import com.gsd.techbloghub.core.client.woowahan.dto.http.WoowahanTbRequest
import com.gsd.techbloghub.core.client.woowahan.dto.http.WoowahanTbResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2023/02/08.
 **/
@Component
class TestRunner @Autowired constructor(
    private val woowahanTbClient: WoowahanTbClient,
    private val naverTbClient: NaverTbClient,
    private val kakaoTbClient: KakaoTbClient,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
//        val wwh: WoowahanTbResponse = woowahanTbClient.getPosts(WoowahanTbRequest.from(1))
//        val naver = naverTbClient.getList(1, 10)
//        val kakao = kakaoTbClient.getList(1)
    }

}