package com.gsd.techbloghub.web.domain.content.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

class ContentSearch(
    @Schema(description = "검색 질의", defaultValue = "백엔드", required = false)
    val query: String?,
    @Schema(description = "현재까지 조회한 마지막 ID", defaultValue = "10", required = false)
    val currentNextId: Long? = 1,

    @Schema(description = "가져올 데이터 크기(기본 10)", defaultValue = "10", required = false)
    val pageSize: Int? = 10
) {
}