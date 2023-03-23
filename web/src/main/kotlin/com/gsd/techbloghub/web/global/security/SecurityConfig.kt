package com.gsd.techbloghub.web.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

/**
 * Created by Yohan lee
 * Created on 2023/03/24.
 **/

@Configuration
@EnableWebSecurity
class SecurityConfig {


    @Bean
    fun config(http: HttpSecurity): SecurityFilterChain {
        http.oauth2Login()
            .authorizationEndpoint()
            .baseUri("/login")

        return http.build()
    }
}