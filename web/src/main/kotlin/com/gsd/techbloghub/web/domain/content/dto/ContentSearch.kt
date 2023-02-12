package com.gsd.techbloghub.web.domain.content.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/
@ApiModel("컨텐츠 검색 Query")
class ContentSearch(
    @ApiModelProperty(value = "검색 질의", example = "백엔드")
    val query: String?,
    @ApiModelProperty(value = "현재까지 조회한 마지막 ID", example = "백엔드")
    val currentNextId: Long? = 1,
    @ApiModelProperty(value = "가져올 데이터 크기(기본 10)", example = "10")
    val pageSize: Int? = 10
) {
}