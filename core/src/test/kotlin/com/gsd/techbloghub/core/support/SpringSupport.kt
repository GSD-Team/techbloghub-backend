package com.gsd.techbloghub.core.support

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 **/

@SpringBootTest(
    properties = [
        "spring.main.allow-bean-definition-overriding=true"
    ]
)
@Import(SpringSupport.Config::class)
class SpringSupport {


    @TestConfiguration
    class Config {


        @Bean
        fun objectMapper(): ObjectMapper {
            val objectMapper = ObjectMapper()
            objectMapper.registerModule(JavaTimeModule())
            //기본생성자 에러 방지.
            objectMapper.registerModule(
                KotlinModule.Builder()
                    .withReflectionCacheSize(512)
                    .configure(KotlinFeature.NullToEmptyCollection, false)
                    .configure(KotlinFeature.NullToEmptyMap, false)
                    .configure(KotlinFeature.NullIsSameAsDefault, false)
                    .configure(KotlinFeature.SingletonSupport, false)
                    .configure(KotlinFeature.StrictNullChecks, false)
                    .build()
            )
            //class에 선언되지 않은 필드가 있을 때 에러발생 방지.
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            return objectMapper
        }
    }
}