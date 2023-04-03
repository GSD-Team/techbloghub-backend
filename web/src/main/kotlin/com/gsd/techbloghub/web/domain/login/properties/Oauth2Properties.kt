package com.gsd.techbloghub.web.domain.login.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/

@Component
@PropertySource("classpath:security-config.yml")
class Oauth2Properties {
    @Value("\${spring.security.oauth2.client.registration.github.client-id}")
    lateinit var githubClientId: String

    @Value("\${spring.security.oauth2.client.registration.github.client-secret}")
    lateinit var githubClientSecret: String
}