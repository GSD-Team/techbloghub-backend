package com.gsd.techbloghub.web.domain.content.controller.api

import com.gsd.techbloghub.web.domain.content.dto.ContentList
import com.gsd.techbloghub.web.domain.content.dto.ContentSearch
import com.gsd.techbloghub.web.global.dto.ApiResult
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

@Api(tags = ["컨텐츠 API"])
interface ContentAPI {


    @ApiOperation(value = "컨텐츠 리스트 API")
    fun getContents(search: ContentSearch): ApiResult<ContentList>
}