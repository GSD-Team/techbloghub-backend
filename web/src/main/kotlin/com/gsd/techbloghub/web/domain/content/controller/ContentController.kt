package com.gsd.techbloghub.web.domain.content.controller

import com.gsd.techbloghub.core.function.isNotNullAndBlank
import com.gsd.techbloghub.core.function.isNotNullAndMoreThan
import com.gsd.techbloghub.web.domain.content.controller.api.ContentAPI
import com.gsd.techbloghub.web.domain.content.dto.ContentList
import com.gsd.techbloghub.web.domain.content.dto.search.ContentSearch
import com.gsd.techbloghub.web.domain.content.service.ContentFindService
import com.gsd.techbloghub.web.global.dto.ApiResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

@RestController
@RequestMapping("/api/contents")
class ContentController @Autowired constructor(
    private val contentFindService: ContentFindService,
) : ContentAPI {

    @GetMapping("")
    override fun getContents(search: ContentSearch): ApiResult<ContentList> {
        if (search.query.isNotNullAndBlank() && search.query!!.length < 2) {
            throw IllegalArgumentException("검색어는 2글자 이상 입력해주세요.")
        }
        val contents = contentFindService.getAll(search)
        return ApiResult.success(ContentList.resultOf(search, contents))
    }

    @GetMapping("/mock")
    override fun getMockContents(search: ContentSearch): ApiResult<ContentList> {
        return ApiResult.success(ContentList.mock(search))
    }
}