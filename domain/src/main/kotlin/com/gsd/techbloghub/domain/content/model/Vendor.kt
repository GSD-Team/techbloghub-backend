package com.gsd.techbloghub.domain.content.model

import com.gsd.techbloghub.core.client.application.interfaces.PlatformVendor
import com.gsd.techbloghub.core.constant.VendorCode
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/03/18.
 **/

@Entity
@Table(name = "vendor")
@EntityListeners(AuditingEntityListener::class)
class Vendor(

    @Column(name = "vendor_image_link")
    val vendorImageLink: String? = null,

    @Column(name = "vendor_code")
    @Enumerated(EnumType.STRING)
    val vendorCode: VendorCode,

    @Column(name = "vendor_name")
    val vendorName: String,

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {

    fun toPlatformVendor(): PlatformVendor {
        return PlatformVendor(
            id = id!!,
            name = vendorName,
            thumbnailURL = vendorImageLink,

            )
    }
}