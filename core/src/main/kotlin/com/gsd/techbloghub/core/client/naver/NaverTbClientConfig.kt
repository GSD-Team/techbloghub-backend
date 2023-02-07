package com.gsd.techbloghub.core.client.naver

import feign.RequestInterceptor
import org.springframework.context.annotation.Bean

/**
 * Created by Yohan lee
 * Created on 2023/02/08.
 **/
class NaverTbClientConfig {


    @Bean
    fun naverTbClientRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate ->
            requestTemplate.query("categoryId", "2") //기술블로그 포스팅만 가져옴.
        }
    }
}