package com.gsd.techbloghub.web.domain.login.service

import com.gsd.techbloghub.core.client.oauth.GithubOauthClient
import com.gsd.techbloghub.domain.user.repository.UserRepository
import com.gsd.techbloghub.web.domain.login.dto.LoginUser
import com.gsd.techbloghub.web.domain.login.properties.Oauth2Properties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/

@Service
class OauthLoginService @Autowired constructor(
    private val oauth2Properties: Oauth2Properties,
    private val githubOauthClient: GithubOauthClient,
    private val userRepository: UserRepository,
) {

    fun loginGithub(userCode: String): LoginUser {
        val tokenResponse = githubOauthClient.getAccessToken(
            clientId = oauth2Properties.githubClientId,
            clientSecret = oauth2Properties.githubClientSecret,
            code = userCode
        )
        if (tokenResponse.isEmpty()) {
            throw IllegalArgumentException("accessToken is empty")
        }
        val accessToken = tokenResponse
            .split("&")[0]
            .split("=")[1]
        val userInfo = githubOauthClient.loginUser("${BEARER}${accessToken}")

        return LoginUser()
    }


    companion object {
        const val BEARER = "Bearer "
    }
}