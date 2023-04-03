package com.gsd.techbloghub.web.domain.login.controller

import com.gsd.techbloghub.web.domain.login.controller.api.LoginAPI
import com.gsd.techbloghub.web.domain.login.dto.LoginUser
import com.gsd.techbloghub.web.domain.login.service.OauthLoginService
import com.gsd.techbloghub.web.global.dto.ApiResult
import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/

@RestController
@RequestMapping("/api/login")
class LoginController @Autowired constructor(
    private val oauthLoginService: OauthLoginService,
) : LoginAPI {
    @GetMapping("/github")
    override fun loginGithub(@RequestParam("code") @NotBlank(message = "code는 필수 값입니다.") code: String): ApiResult<LoginUser> {
        return ApiResult.success(oauthLoginService.loginGithub(code))
    }
}