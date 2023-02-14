package com.gsd.techbloghub.web.global.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.web.PageableHandlerMethodArgumentResolver
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

@Configuration
class WebMvcConfig : WebMvcConfigurer {


    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**") //어떤 RequestMapping에 이 Custom CORS Setting을 적용할껀지..
            .allowedOriginPatterns("*") //허용할 Origin선택
            .allowedMethods(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name(),
                HttpMethod.OPTIONS.name()
            )
    }

    fun pageableHandlerMethodArgumentResolver(): PageableHandlerMethodArgumentResolver {
        return PageableHandlerMethodArgumentResolver().apply {
            setOneIndexedParameters(true)
        }
    }

}