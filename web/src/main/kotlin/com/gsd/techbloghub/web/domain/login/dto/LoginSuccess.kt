package com.gsd.techbloghub.web.domain.login.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by Yohan lee
 * Created on 2023/04/07.
 **/

@Schema(description = "로그인 성공 시 반환되는 Object")
class LoginSuccess(
    @Schema(description = "로그인한 사용자의 AccessToken")
    val accessToken: String,
    @Schema(description = "로그인한 사용자 정보")
    val loginUser: LoginUser,
) {
}