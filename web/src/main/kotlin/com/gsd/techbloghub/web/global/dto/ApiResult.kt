package com.gsd.techbloghub.web.global.dto

import com.gsd.techbloghub.web.global.constants.ApiResultCode
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by Yohan lee
 * Created on 2023/02/13.
 **/
class ApiResult<T> private constructor(

    @Schema(description = "요청 결과 코드", example = "SUCCESS, INVALID_DATA, NOT_FOUND_DATA, UNKNOWN_ERROR")
    val resultCode: ApiResultCode,

    @Schema(description = "결과 메시지", example = "성공 시, success 고정. 에러 발생 시, 에러메시지")
    val message: String?,

    @Schema(description = "요청 결과")
    val data: T?,
) {

    companion object {
        fun success(): ApiResult<Unit> {
            return ApiResult(ApiResultCode.SUCCESS, "success", null)
        }


        fun <T> success(data: T): ApiResult<T> {
            return ApiResult(ApiResultCode.SUCCESS, "success", data)
        }


        fun error(msg: String): ApiResult<Any> {
            return ApiResult(ApiResultCode.INVALID_DATA, msg, null)
        }

        fun error(msg: String, apiResultCode: ApiResultCode): ApiResult<Any> {
            return ApiResult(apiResultCode, msg, null)
        }

        fun error(throwable: Throwable): ApiResult<Any> {
            return ApiResult(ApiResultCode.INVALID_DATA, throwable.message, null)
        }

        fun error(invalidParams: List<String>): ApiResult<Any> {
            return ApiResult(ApiResultCode.INVALID_DATA, "유효하지 않은 요청입니다.", invalidParams)
        }


    }
}