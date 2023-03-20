package com.gsd.techbloghub.web.domain.content.service

import com.gsd.techbloghub.core.client.application.interfaces.BlogContents
import com.gsd.techbloghub.core.constant.VendorCode
import com.gsd.techbloghub.domain.content.constant.ContentType
import com.gsd.techbloghub.domain.content.model.ContentScrap
import com.gsd.techbloghub.domain.content.model.Vendor
import com.gsd.techbloghub.domain.content.repository.ContentScrapRepository
import com.gsd.techbloghub.web.domain.content.dto.vendor.VendorDto
import com.gsd.techbloghub.web.domain.content.repository.ContentScrapQueryRepository
import com.gsd.techbloghub.web.domain.content.repository.VendorQueryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/

@Service
class VendorService @Autowired constructor(
    private val vendorQueryRepository: VendorQueryRepository,
    private val contentScrapQueryRepository: ContentScrapQueryRepository,
    private val contentScrapRepository: ContentScrapRepository,
) {
    fun getVendor(vendorCode: VendorCode): VendorDto {
        val vendor = findVendor(vendorCode)
        return VendorDto.from(vendor)
    }

    fun findVendor(vendorCode: VendorCode): Vendor {
        return vendorQueryRepository.findBy(vendorCode)
            ?: throw IllegalArgumentException("존재하지 않는 Vendor입니다.")
    }

    @Transactional
    fun getLastScrap(vendorCode: VendorCode, contentType: ContentType): ContentScrap {
        val lastScrap = contentScrapQueryRepository.getLastScrapInfo(vendorCode, contentType)
        if (lastScrap == null) {
            val contentScrap = ContentScrap.of(findVendor(vendorCode), contentType)
            return contentScrapRepository.save(contentScrap)
        }

        return lastScrap
    }

    @Transactional
    fun completeScrap(vendorCode: VendorCode, blogContents: BlogContents) {
        val contentScrap = getLastScrap(vendorCode, ContentType.BLOG)
        contentScrap.completeScrap(blogContents)
    }
}