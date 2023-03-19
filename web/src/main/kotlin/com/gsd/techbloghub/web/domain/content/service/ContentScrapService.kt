package com.gsd.techbloghub.web.domain.content.service

import com.gsd.techbloghub.core.client.application.interfaces.BlogContent
import com.gsd.techbloghub.core.constant.VendorCode
import com.gsd.techbloghub.domain.content.model.Content
import com.gsd.techbloghub.domain.content.repository.ContentRepository
import com.gsd.techbloghub.domain.content.repository.ContentTagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 **/

@Service
class ContentScrapService @Autowired constructor(
    private val contentRepository: ContentRepository,
    private val contentTagRepository: ContentTagRepository,
    private val vendorService: VendorService,
) {


    @Transactional
    fun addAll(code: VendorCode, contents: List<BlogContent>) {
        val vendor = vendorService.findVendor(code)
        val contentList = contents.map { Content.of(it, vendor) }
        contentRepository.saveAll(contentList)
    }
}