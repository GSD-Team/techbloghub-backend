package com.gsd.techbloghub.web.global.security.filter

import com.gsd.techbloghub.web.domain.login.dto.LoginUser
import com.gsd.techbloghub.web.global.component.JwtProperties
import com.gsd.techbloghub.web.global.component.JwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.stereotype.Component

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/
@Component
class LoginCheckFilter(
    authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
) : BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        getToken(request)?.let { token ->
            try {
                val loginUser: LoginUser = jwtTokenProvider.getBody(token)
                SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(
                    loginUser,
                    null,
                    listOf(SimpleGrantedAuthority("user"))
                )
            } catch (e: Exception) {
                logger.error(e.message)
            }
        }

        super.doFilterInternal(request, response, chain)

    }


    private fun getToken(request: HttpServletRequest): String? {
        val authorization = request.getHeader("Authorization")
        if (!authorization.isNullOrBlank()) {
            return authorization.replaceFirst(JwtProperties.BEARER, "")
        }
        return null
    }
}