package com.gsd.techbloghub.web.domain.login.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.gsd.techbloghub.domain.user.model.User
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/
@Schema(description = "로그인 유저 정보")
class LoginUser(
    @Schema(description = "사용자 식별자")
    var id: Long,
    @Schema(description = "사용자 이름")
    val userName: String,
    @Schema(description = "사용자 프로필 이미지 URL")
    var profileImageURL: String? = null,
    @Schema(description = "최근 로그인 날짜")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    var recentLoginDate: LocalDateTime,
    @Schema(description = "회원가입 날짜")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    var registerDate: LocalDateTime,
) {


    companion object {
        fun from(user: User): LoginUser {
            return LoginUser(
                id = user.id!!,
                userName = user.name,
                profileImageURL = user.profileImageURL,
                recentLoginDate = user.recentLoginDate!!,
                registerDate = user.registerDate!!,
            )
        }
    }
}