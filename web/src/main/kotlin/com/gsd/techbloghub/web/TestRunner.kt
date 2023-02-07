package com.gsd.techbloghub.web

import com.gsd.techbloghub.core.client.woowahan.WoowahanTbClient
import com.gsd.techbloghub.core.client.woowahan.dto.WoowahanTbRequest
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
    private val woowahanTbClient: WoowahanTbClient
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val posts = woowahanTbClient.getPosts(WoowahanTbRequest.from(1))
    }

}