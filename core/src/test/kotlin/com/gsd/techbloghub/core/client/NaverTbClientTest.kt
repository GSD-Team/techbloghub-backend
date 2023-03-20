package com.gsd.techbloghub.core.client

import com.gsd.techbloghub.core.client.naver.NaverTbClient
import com.gsd.techbloghub.core.support.SpringSupport
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 **/
class NaverTbClientTest @Autowired constructor(
    private val naverTbClient: NaverTbClient,
) : SpringSupport() {

    @Test
    @DisplayName("포스트 목록을 가져온다.")
    fun getPosts() {
        val response = naverTbClient.getPosts(0)
        response.contents.forEach {
            println(it.title)
            println(it.link)
            println(it.postDate)
        }
    }
}