package com.gsd.techbloghub.core.client.application

import com.fasterxml.jackson.annotation.JsonFormat
import com.gsd.techbloghub.core.vo.DatePattern
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/

class BlogContent(
    @Schema(description = "제목", required = true)
    val title: String,
    @Schema(description = "포스팅 링크", required = true)
    val link: String,
    @Schema(description = "포스팅 썸네일")
    val thumbnailURL: String? = null,
    @Schema(description = "포스팅 발췌(포스팅 글 일부 발췌한 내용)")
    val excerpt: String,
    @Schema(description = "벤더사 정보", required = true)
    val platformVendor: PlatformVendor,
    @Schema(description = "포스팅 날짜", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.YYYY_MM_DD_STR)
    val postDate: LocalDate,
    @Schema(description = "데이터 스크랩 날짜", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.YYYY_MM_DD_HH_MM_SS_STR)
    val scrapDate: LocalDateTime
) {
}