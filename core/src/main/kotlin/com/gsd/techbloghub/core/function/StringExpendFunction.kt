package com.gsd.techbloghub.core.function

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Created by Yohan lee
 * Created on 2023/03/20.
 **/
@OptIn(ExperimentalContracts::class)
fun String?.isNotNullAndBlank(): Boolean {
    contract {
        returns(false) implies (this@isNotNullAndBlank != null)
    }
    if (!this.isNullOrBlank()) {
        return true
    }
    return false
}

@OptIn(ExperimentalContracts::class)
fun String?.isNotNullAndMoreThan(length: Int): Boolean {
    contract {
        returns(false) implies (this@isNotNullAndMoreThan != null)
    }

    return this != null && length < this.length
}

