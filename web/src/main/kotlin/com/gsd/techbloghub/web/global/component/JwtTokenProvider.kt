package com.gsd.techbloghub.web.global.component

import com.fasterxml.jackson.databind.ObjectMapper
import com.gsd.techbloghub.domain.user.model.User
import com.gsd.techbloghub.web.domain.login.dto.LoginUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.jackson.io.JacksonDeserializer
import io.jsonwebtoken.jackson.io.JacksonSerializer
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

/**
 * Created by Yohan lee
 * Created on 2023/04/04.
 **/
@Component
class JwtTokenProvider @Autowired constructor(
    private val objectMapper: ObjectMapper,
) {
    @Value("\${jwt.signing-key}")
    private lateinit var signingKeyValue: String
    private lateinit var jwtParser: JwtParser
    private lateinit var signingKey: SecretKey

    @PostConstruct
    fun init() {
        this.signingKey = Keys.hmacShaKeyFor(signingKeyValue.toByteArray())
        this.jwtParser = Jwts.parserBuilder()
            .setSigningKey(signingKey)
            .build()

    }

    fun createAccessToken(user: LoginUser): String {
        val claims: Claims = Jwts.claims(buildMap<String, LoginUser> {
            put(JwtProperties.USER_INFO_KEY, user)
        })
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + JwtProperties.ACCESS_TOKEN_MILLI_SEC))
            .signWith(signingKey, SignatureAlgorithm.HS256)
            // 라이브러리상에서 사용하는 ObjectMapper는 LocalDatetime 파싱 시, 에러발생함으로 교체.
            .serializeToJsonWith(JacksonSerializer(objectMapper))
            .compact()
    }

    fun getBody(token: String): LoginUser {
        val clearToken = token
            .replaceFirst(JwtProperties.BEARER, "")
            .trim()
        val body = Jwts.parserBuilder()
            .setSigningKey(signingKey)
            .build()
            .parseClaimsJws(clearToken).body[JwtProperties.USER_INFO_KEY] ?: throw NullPointerException("JWT Body is null.")
        return objectMapper.convertValue(body, LoginUser::class.java)

    }

}

object JwtProperties {
    const val BEARER = "Bearer "
    const val ACCESS_TOKEN_MILLI_SEC: Long = 1000 * 60 * 60 * 8L //8시간
    const val USER_INFO_KEY = "user"
}