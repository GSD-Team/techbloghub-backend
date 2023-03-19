package com.gsd.techbloghub.web.domain.content.repository

import com.gsd.techbloghub.core.constant.VendorCode
import com.gsd.techbloghub.domain.content.constant.ContentType
import com.gsd.techbloghub.domain.content.model.ContentScrap
import com.gsd.techbloghub.domain.content.model.QContentScrap
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/

@Repository
class ContentScrapQueryRepository @Autowired constructor(
    private val queryFactory: JPAQueryFactory,
) {

    fun getLastScrapInfo(vendorCode: VendorCode, contentType: ContentType): ContentScrap? {
        val contentScrap = QContentScrap.contentScrap
        return queryFactory
            .select(contentScrap)
            .from(contentScrap)
            .join(contentScrap.vendor).fetchJoin()
            .where(
                contentScrap.vendor.vendorCode.eq(vendorCode),
                contentScrap.contentType.eq(contentType)
            )
            .fetchOne()
    }
}