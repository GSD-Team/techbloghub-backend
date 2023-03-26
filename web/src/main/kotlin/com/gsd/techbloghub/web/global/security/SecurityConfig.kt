package com.gsd.techbloghub.web.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsUtils

/**
 * Created by Yohan lee
 * Created on 2023/03/24.
 **/

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun config(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic().disable()
            .formLogin().disable()
            .csrf().disable()
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                it.anyRequest().permitAll()
            }
            .oauth2Login()
            .authorizationEndpoint()
            .baseUri("/login")

        return http.build()
    }
}