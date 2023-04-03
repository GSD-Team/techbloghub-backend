package com.gsd.techbloghub.web.global.security.filter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/
@Component
class LoginCheckFilter(
    private val authenticationManager: AuthenticationManager,
) : BasicAuthenticationFilter(authenticationManager) {
}