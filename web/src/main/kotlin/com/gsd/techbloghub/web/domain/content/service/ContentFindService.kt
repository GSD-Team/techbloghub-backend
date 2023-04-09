package com.gsd.techbloghub.web.domain.content.service

import com.gsd.techbloghub.web.domain.content.dto.ContentDto
import com.gsd.techbloghub.web.domain.content.dto.search.ContentSearch
import com.gsd.techbloghub.web.domain.content.repository.ContentQueryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 * 블로그 컨텐츠 조회 서비스 레이어
 * 데이터 변경 없이, 조회만 하는 함수만 작성.
 **/

@Service
@Transactional(readOnly = true)
class ContentFindService @Autowired constructor(
    private val contentQueryRepository: ContentQueryRepository,
) {
    fun getAll(search: ContentSearch): List<ContentDto> {
        return contentQueryRepository.findAllNoOffset(
            offsetId = search.currentNextId,
            pageSize = search.pageSize,
            query = search.query,
            vendorCode = search.vendorCode,
        )
            .map { ContentDto.of(it) }
            .toList()
    }
}