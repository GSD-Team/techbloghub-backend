package com.gsd.techbloghub.core.config

import feign.Logger
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Yohan lee
 * Created on 2023/02/08.
 **/

@EnableFeignClients(basePackages = ["com.gsd.techbloghub"])
@Configuration
class FeignClientGlobalConfig {

    @Bean
    fun loggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }
}