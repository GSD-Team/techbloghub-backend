package com.gsd.techbloghub.core.client.woowahan

import org.springframework.cloud.openfeign.FeignClient

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/
@FeignClient(
    url = "https://techblog.woowahan.com"
)
interface WoowahanTbClient {
}