package com.gsd.techbloghub.web.domain.content.dto.vendor

import com.gsd.techbloghub.core.client.application.interfaces.PlatformVendor
import com.gsd.techbloghub.core.constant.VendorCode
import com.gsd.techbloghub.domain.content.model.ContentScrap
import com.gsd.techbloghub.domain.content.model.Vendor
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/
class VendorDto(
    var id: Long,
    val vendorName: String,
    val vendorCode: VendorCode,
    val vendorImageLink: String? = null,
    var createdDate: LocalDateTime? = null,

    ) {
    fun toPlatformVendor(): PlatformVendor {
        return PlatformVendor(
            id = id,
            name = vendorName,
            thumbnailURL = vendorImageLink,
        )
    }


    companion object {
        fun from(vendor: Vendor): VendorDto {
            return VendorDto(
                id = vendor.id!!,
                vendorName = vendor.vendorName,
                vendorCode = vendor.vendorCode,
                vendorImageLink = vendor.vendorImageLink,
                createdDate = vendor.createdDate,
            )
        }
    }
}