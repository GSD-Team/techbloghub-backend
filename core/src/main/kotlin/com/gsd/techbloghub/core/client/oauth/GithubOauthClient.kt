package com.gsd.techbloghub.core.client.oauth

import com.gsd.techbloghub.core.client.oauth.http.GithubOauth2User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import java.net.URI

/**
 * Created by Yohan lee
 * Created on 2023/04/02.
 **/

@Component
@FeignClient(
    name = "githubOauthClient",
    url = "https://api.github.com",
    configuration = [GithubOauthClientConfig::class]
)
interface GithubOauthClient {


    @GetMapping(path = ["/login/oauth/access_token"])
    fun getAccessToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String,
        uri: URI = URI.create("https://github.com"),
    ): String

    @GetMapping("/user")
    fun loginUser(@RequestHeader("Authorization") authorization: String): GithubOauth2User

}