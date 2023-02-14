package com.gsd.techbloghub.web.global.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 * https://springdoc.org/ 참고
 **/

@Configuration
class SpringDocConfig {


    @Bean
    fun openAPI(@Value("\${springdoc.version}") version: String): OpenAPI {
        val info = Info()
            .title("TechBlogHub API")
            .version(version)
            .description("TechBlogHub API")
        return OpenAPI()
            .info(info)
            .components(Components())

    }

}