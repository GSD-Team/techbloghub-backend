package com.gsd.techbloghub.web.global.security

import com.gsd.techbloghub.core.client.oauth.GithubOauthClient
import com.gsd.techbloghub.web.global.security.filter.LoginCheckFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.web.cors.CorsUtils

/**
 * Created by Yohan lee
 * Created on 2023/03/24.
 **/

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(
    private val authConfig: AuthenticationConfiguration,
) {
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


        return http.build()
    }


    private fun loginCheckFilter(): BasicAuthenticationFilter {
        return LoginCheckFilter(authConfig.authenticationManager)
    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }
}