package com.gsd.techbloghub.web.domain.content.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.gsd.techbloghub.core.vo.DatePattern
import com.gsd.techbloghub.web.domain.vendor.dto.VendorDto
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

@ApiModel("컨텐츠")
class ContentDto(
    @ApiModelProperty(value = "제목", required = true)
    val title: String,
    @ApiModelProperty(value = "포스팅 링크", required = true)
    val link: String,
    @ApiModelProperty(value = "벤더사 정보", required = true)
    val vendor: VendorDto,
    @ApiModelProperty(value = "생성일", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.YYYY_MM_DD_HH_MM_SS_STR)
    val createdDate: LocalDateTime
) {
}