package com.gsd.techbloghub.web.domain.login.controller.api

import com.gsd.techbloghub.web.domain.login.dto.LoginUser
import com.gsd.techbloghub.web.global.dto.ApiResult
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/

@Tag(name = "로그인 API", description = "Oauth2 & 일반 로그인 관련 API")
interface LoginAPI {

    @Operation(summary = "깃허브 Oauth2 로그인 API")
    fun loginGithub(@Schema(description = "사용자 Github 인증 코드") code: String): ApiResult<LoginUser>
}