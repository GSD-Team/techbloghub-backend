package com.gsd.techbloghub.web.domain.login.service

import com.gsd.techbloghub.domain.user.model.User
import com.gsd.techbloghub.web.domain.login.dto.LoginSuccess

/**
 * Created by Yohan lee
 * Created on 2023/04/07.
 **/
interface Oauth2LoginService<Oauth2User> {
    fun login(userCode: String): LoginSuccess

    fun getOrCreateUser(userInfo: Oauth2User): User
}