package com.gsd.techbloghub.web.domain.content.repository

import com.gsd.techbloghub.core.constant.VendorCode
import com.gsd.techbloghub.domain.content.model.QVendor
import com.gsd.techbloghub.domain.content.model.Vendor
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/

@Repository
class VendorQueryRepository @Autowired constructor(
    private val queryFactory: JPAQueryFactory,
) {


    fun findBy(code: VendorCode?): Vendor? {
        val vendor = QVendor.vendor
        return queryFactory
            .select(vendor)
            .from(vendor)
            .where(
                code?.let { vendor.vendorCode.eq(it) }
            )
            .fetchOne()
    }
}