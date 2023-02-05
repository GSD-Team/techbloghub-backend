package com.gsd.techbloghub.core.client.naver

import org.springframework.cloud.openfeign.FeignClient

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/
@FeignClient(
    url = "https://d2.naver.com"
)
interface NaverTbClient {
}