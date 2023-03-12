package com.gsd.techbloghub.core.util

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 **/
object FeignUtil {

    fun responseToString(response: feign.Response): String {
        return response.body()
            .asInputStream()
            .bufferedReader()
            .use { it.readText() }
    }
}