package com.gsd.techbloghub.web.global.error

import com.gsd.techbloghub.web.global.dto.ApiResult
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 **/

@RestControllerAdvice
class ControllerErrorHandler {


    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentExceptionHandler(ex: IllegalArgumentException): ApiResult<Any> {
        return ApiResult.error(ex.message ?: "잘못된 요청입니다.")
    }
}