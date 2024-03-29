package com.gsd.techbloghub.core.vo

import java.time.format.DateTimeFormatter

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/
object DatePattern {

    const val YYYY_MM_DD_HH_MM_SS_STR = "yyyy-MM-dd HH:mm:ss"
    val YYYY_MM_DD_HH_MM_SS: DateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS_STR)
    const val YYYY_MM_DD_STR = "yyyy-MM-dd"
    val YYYY_MM_DD: DateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_STR)
    const val DOT_YYYY_MM_DD_STR = "yyyy.MM.dd"
    val DOT_YYYY_MM_DD: DateTimeFormatter = DateTimeFormatter.ofPattern(DOT_YYYY_MM_DD_STR)
}