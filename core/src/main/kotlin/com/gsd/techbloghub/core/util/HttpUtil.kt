package com.gsd.techbloghub.core.util

import org.springframework.web.util.UriComponentsBuilder
import java.lang.IllegalArgumentException

/**
 * Created by Yohan lee
 * Created on 2023/03/17.
 **/
object HttpUtil {

    fun extractPath(url: String): String {
        return UriComponentsBuilder
            .fromUriString(url)
            .build()
            .path ?: throw IllegalArgumentException("URL Path does not exist.")
    }
}