package com.gsd.techbloghub.core.client.kakao

import org.springframework.cloud.openfeign.FeignClient

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/

@FeignClient(
    url = "https://tech.kakao.com"
)
interface KakaoTbClient {
}