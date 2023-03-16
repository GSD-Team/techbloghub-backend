package com.gsd.techbloghub.core.client

import com.gsd.techbloghub.core.client.kakao.KakaoTbClient
import com.gsd.techbloghub.core.support.SpringSupport
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by Yohan lee
 * Created on 2023/03/17.
 **/
class KakaoTbClientTest @Autowired constructor(
    private val kakaoTbClient: KakaoTbClient,
) : SpringSupport() {

    @Test
    @DisplayName("포스트 목록을 가져온다.")
    fun getPosts() {
        val response = kakaoTbClient.getList(0)
        response.forEach {
            println(it.title)
            println(it.id)
            println(it.postDate)
            println(it.excerpt)
        }
    }

}