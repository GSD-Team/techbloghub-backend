package com.gsd.techbloghub.web.domain.content.dto.search

import com.gsd.techbloghub.core.constant.VendorCode
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import org.springdoc.core.annotations.ParameterObject

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/
@ParameterObject
class ContentSearch(

    @field:Parameter(description = "검색 질의", example = "백엔드", required = false)
    val query: String?,
    @field:Parameter(description = "회사 필터", example = "KAKAO", required = false)
    val vendorCode: VendorCode?,
    @field:Parameter(description = "현재까지 조회한 마지막 ID(0부터 시작)", example = "0", required = false)
    val currentNextId: Long = 0,

    @field:Parameter(description = "가져올 데이터 크기(기본 10)", example = "10", required = false)
    val pageSize: Int = 10
) {

    @get:Parameter(hidden = true)
    val nextCurrentId: Long
        get() = currentNextId + pageSize
}