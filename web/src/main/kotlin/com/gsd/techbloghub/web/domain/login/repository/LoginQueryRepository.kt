package com.gsd.techbloghub.web.domain.login.repository

import com.gsd.techbloghub.domain.user.model.QUser
import com.gsd.techbloghub.domain.user.model.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by Yohan lee
 * Created on 2023/04/07.
 **/

@Repository
class LoginQueryRepository @Autowired constructor(
    private val queryFactory: JPAQueryFactory,
) {

    fun findGithubUser(githubLoginId: String): User? {
        val user = QUser.user
        return queryFactory
            .select(user)
            .from(user)
            .where(user.githubLoginId.eq(githubLoginId))
            .fetchOne()
    }
}