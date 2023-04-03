package com.gsd.techbloghub.core.client.oauth.http

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/
class GithubOauth2User(
    @JsonProperty("login")
    val userName: String,
) {
}