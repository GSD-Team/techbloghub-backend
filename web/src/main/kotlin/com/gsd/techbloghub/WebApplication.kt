package com.gsd.techbloghub

import com.gsd.techbloghub.core.client.oauth.GithubOauthClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Yohan lee
 * Created on 2023/02/05.
 **/
@SpringBootApplication
class WebApplication

fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}


@RestController
class Controller @Autowired constructor(
    private val githubOauthClient: GithubOauthClient,
) {

    @GetMapping("/login-result")
    fun test(code: String): Map<String, String> {
        //TODO code를 이용해서 access token을 받아오는 로직을 구현해야함
        //TODO access token을 이용해서 유저 정보를 받아오는 로직을 구현해야함
        return mapOf(
            "code" to code
        )
    }
}