package com.gsd.techbloghub.web.global.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/

@Configuration
class QueryDSLConfig @Autowired constructor(
    private val entityManager: EntityManager,
) {

    @Bean
    fun queryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }


}