package com.gsd.techbloghub.web.domain.login.service

import com.gsd.techbloghub.core.client.oauth.GithubOauthClient
import com.gsd.techbloghub.core.client.oauth.http.GithubOauth2User
import com.gsd.techbloghub.domain.user.model.User
import com.gsd.techbloghub.domain.user.repository.UserRepository
import com.gsd.techbloghub.web.domain.login.dto.LoginSuccess
import com.gsd.techbloghub.web.domain.login.dto.LoginUser
import com.gsd.techbloghub.web.domain.login.properties.Oauth2Properties
import com.gsd.techbloghub.web.domain.login.repository.LoginQueryRepository
import com.gsd.techbloghub.web.global.component.JwtProperties
import com.gsd.techbloghub.web.global.component.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/

@Service
class GithubLoginService @Autowired constructor(
    private val oauth2Properties: Oauth2Properties,
    private val githubOauthClient: GithubOauthClient,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository,
    private val loginQueryRepository: LoginQueryRepository,
) : Oauth2LoginService<GithubOauth2User> {

    @Transactional
    override fun login(userCode: String): LoginSuccess {
        val tokenResponse = githubOauthClient.getAccessToken(
            clientId = oauth2Properties.githubClientId,
            clientSecret = oauth2Properties.githubClientSecret,
            code = userCode
        )
        val githubAccessToken = validateAndGetGithubToken(tokenResponse)
        val githubOauth2User = githubOauthClient.loginUser("${JwtProperties.BEARER}${githubAccessToken}")
        val user = getOrCreateUser(githubOauth2User)
        user.login()
        val loginUser = LoginUser.from(user)
        return LoginSuccess.jwtOf(jwtTokenProvider.createAccessToken(loginUser), loginUser)
    }

    private fun validateAndGetGithubToken(githubAccessToken: String): String {
        if (githubAccessToken.isEmpty()) {
            throw IllegalArgumentException("accessToken is empty")
        }
        return githubAccessToken
            .split("&")[0]
            .split("=")[1]
    }

    override fun getOrCreateUser(userInfo: GithubOauth2User): User {
        val user = loginQueryRepository.findGithubUser(userInfo.userId)
        if (user != null) {
            return user
        }
        return userRepository.save(User.githubOf(userInfo))
    }


}