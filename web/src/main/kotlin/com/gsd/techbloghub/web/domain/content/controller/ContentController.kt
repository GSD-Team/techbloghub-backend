package com.gsd.techbloghub.web.domain.content.controller

import com.gsd.techbloghub.web.domain.content.controller.api.ContentAPI
import com.gsd.techbloghub.web.domain.content.dto.ContentList
import com.gsd.techbloghub.web.domain.content.dto.ContentSearch
import com.gsd.techbloghub.web.global.dto.ApiResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

@RestController
@RequestMapping("/api/contents")
class ContentController : ContentAPI {

    @GetMapping("")
    override fun getContents(search: ContentSearch): ApiResult<ContentList> {
        return ApiResult.success(ContentList(0L, listOf()))
    }

    @GetMapping("/mock")
    override fun getMockContents(search: ContentSearch): ApiResult<ContentList> {
        return ApiResult.success(ContentList.mock(search))
    }
}