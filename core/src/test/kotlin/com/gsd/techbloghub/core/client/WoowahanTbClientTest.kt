package com.gsd.techbloghub.core.client

import com.gsd.techbloghub.core.client.woowahan.WoowahanTbClient
import com.gsd.techbloghub.core.client.woowahan.http.WoowahanTbRequest
import com.gsd.techbloghub.core.support.SpringSupport
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.assertj.core.api.AssertionsForInterfaceTypes.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 **/


class WoowahanTbClientTest @Autowired constructor(
    private val woowahanTbClient: WoowahanTbClient,
) : SpringSupport() {


    @Test
    @DisplayName("포스트 목록을 가져온다.")
    fun getPosts() {
        val request = WoowahanTbRequest.from(1)
        val response = woowahanTbClient.getPosts(request)
        response.data.posts.forEach {
            println(it.detail.title)
            assertThat(it.detail.title).isNotBlank()
        }
    }
}