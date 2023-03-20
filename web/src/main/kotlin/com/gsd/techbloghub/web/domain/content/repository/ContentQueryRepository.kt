package com.gsd.techbloghub.web.domain.content.repository

import com.gsd.techbloghub.domain.content.model.Content
import com.gsd.techbloghub.domain.content.model.QContent
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 **/

@Repository
class ContentQueryRepository @Autowired constructor(
    private val queryFactory: JPAQueryFactory,
) {
    fun findAllNoOffset(offsetId: Long, pageSize: Int, query: String?): List<Content> {
        val content = QContent.content
        return queryFactory
            .select(content)
            .from(content)
            .join(content.vendor).fetchJoin()
            .where(
                query?.let { content.title.contains(it) }
            )
            .orderBy(content.postDate.desc())
            .limit(pageSize.toLong())
            .offset(offsetId)
            .fetch()
    }
}