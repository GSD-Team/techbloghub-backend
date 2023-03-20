package com.gsd.techbloghub.core.client.woowahan

import com.gsd.techbloghub.core.client.woowahan.http.WoowahanTbResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/

@Component
@FeignClient(
    name = "woowahanTbClient",
    url = "https://techblog.woowahan.com",
    configuration = [WoowahanTbClientConfig::class]
)
interface WoowahanTbClient {

    @PostMapping(
        value = ["/wp-admin/admin-ajax.php"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE]
    )
    fun getPosts(requestBody: Map<String, *>): WoowahanTbResponse
}