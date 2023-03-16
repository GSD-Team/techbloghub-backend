package com.gsd.techbloghub.web.global.config

import com.gsd.techbloghub.core.constant.VendorCode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/

@Configuration
@EnableScheduling
class SchedulerConfig {


    @Bean
    fun schedulerThreadConfig(): TaskScheduler {
        val threadPoolTaskScheduler = ThreadPoolTaskScheduler()
        //크롤링 대상 사이트 수 * 2 만큼의 스레드를 생성
        threadPoolTaskScheduler.poolSize = VendorCode.values().size * 2
        threadPoolTaskScheduler.threadNamePrefix = "st-"
        return threadPoolTaskScheduler
    }
}