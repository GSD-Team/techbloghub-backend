package com.gsd.techbloghub.core.util

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Created by Yohan lee
 * Created on 2023/03/17.
 **/
class HttpUtilTest {

    @Test
    @DisplayName("URL Path를 추출한다.")
    fun extractPathTest() {
        val url = "https://tech.kakao.com/2023/01/11/promise-cancelation-in-javascript/"
        assertThat(HttpUtil.extractPath(url)).isEqualTo("/2023/01/11/promise-cancelation-in-javascript/")
    }
}