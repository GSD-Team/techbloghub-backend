package com.gsd.techbloghub.core.client.woowahan.dto

import feign.form.FormProperty

/**
 * Created by Yohan lee
 * Created on 2023/02/06.
 **/
class WoowahanTbRequest(val page: Int) {

    companion object {
        fun from(page: Int): Map<String, *> {
            return mapOf(
                Pair("action", "get_posts_data"),
                Pair("data[post][post_status]", "publish"),
                Pair("data[post][paged]", page),
            )
        }
    }
}