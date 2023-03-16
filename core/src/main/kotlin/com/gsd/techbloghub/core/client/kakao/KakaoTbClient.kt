package com.gsd.techbloghub.core.client.kakao

import com.gsd.techbloghub.core.client.kakao.http.KakaoTbPost
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/
@Component
@FeignClient(
    name = "kakaoTbClient",
    url = "https://tech.kakao.com",
    configuration = [KakaoTbClientConfig::class]
)
interface KakaoTbClient {

    @GetMapping("/blog/page/{page}")
    fun getList(@PathVariable("page") page: Int): List<KakaoTbPost>

    @GetMapping("/{year}/{month}/{day}/{title}")
    fun getDetail(
        @PathVariable("year") year: Int,
        @PathVariable("month") month: Int,
        @PathVariable("day") day: Int,
        @PathVariable("title") title: String
    )
}