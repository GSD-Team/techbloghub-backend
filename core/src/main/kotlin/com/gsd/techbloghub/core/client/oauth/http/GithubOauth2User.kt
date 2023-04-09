package com.gsd.techbloghub.core.client.oauth.http

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/
class GithubOauth2User(
    @JsonProperty("login")
    val userId: String,
    @JsonProperty("id")
    val userSeq: String,
    @JsonProperty("name")
    val userName: String,
    @JsonProperty("avatar_url")
    val profileImageURL: String?,
    @JsonProperty("company")
    val company: String?,
    @JsonProperty("bio")
    val jobPosition: String,

    ) {
}