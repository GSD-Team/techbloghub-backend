package com.gsd.techbloghub.web.global.constants

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/
enum class ApiResultCode(
    val value: String
) {

    //정상 요청
    SUCCESS("성공"),

    //유효하지 않는 데이터 요청
    INVALID_DATA("유효하지 않은 요청입니다."),

    //데이터를 찾을수 없음
    NOT_FOUND_DATA("존재하지 않는 데이터입니다."),

    //알수 없는 에러
    UNKNOWN_ERROR("알 수 없는 에러입니다.")
    ;
}