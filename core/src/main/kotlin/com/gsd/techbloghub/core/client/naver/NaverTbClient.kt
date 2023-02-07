package com.gsd.techbloghub.core.client.naver

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/

@Component
@FeignClient(
    name = "naverTbClient",
    url = "https://d2.naver.com",
    configuration = [NaverTbClientConfig::class]
)
interface NaverTbClient {

    @GetMapping("/api/v1/contents")
    fun getList(@RequestParam(value = "page") page: Int, @RequestParam(value = "size") pageSize: Int)

    @GetMapping("/api/v1/contents/{postId}")
    fun getDetail(@PathVariable("postId") postId: Int)
}