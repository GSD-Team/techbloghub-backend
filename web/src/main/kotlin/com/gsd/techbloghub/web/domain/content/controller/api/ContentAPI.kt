package com.gsd.techbloghub.web.domain.content.controller.api

import com.gsd.techbloghub.web.domain.content.dto.ContentList
import com.gsd.techbloghub.web.domain.content.dto.ContentSearch
import com.gsd.techbloghub.web.global.dto.ApiResult
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.tags.Tag

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

@Tag(name = "컨텐츠 API", description = "기술블로그/유튜브 컨텐츠 API")
interface ContentAPI {


    @Operation(summary = "컨텐츠 리스트 조회", description = "컨텐츠 리스트를 조회한다. NoOffset 페이징 방식")
    fun getContents(@Parameter(`in` = ParameterIn.QUERY) search: ContentSearch): ApiResult<ContentList>

    @Operation(summary = "컨텐츠 리스트 Mock 데이터 조회", description = "컨텐츠 리스트를 조회한다. NoOffset 페이징 방식")
    fun getMockContents(@Parameter(`in` = ParameterIn.QUERY) search: ContentSearch): ApiResult<ContentList>
}