package com.gsd.techbloghub.domain.content.model

import com.gsd.techbloghub.core.client.application.interfaces.BlogContents
import com.gsd.techbloghub.domain.content.constant.ContentType
import jakarta.persistence.*
import java.time.LocalDate

/**
 * Created by Yohan lee
 * Created on 2023/03/18.
 **/
@Entity
@Table(name = "content_scrap")
class ContentScrap(

    @Column(name = "last_scrap_post_date")
    var lastScrapPostDate: LocalDate? = null,

    @Column(name = "last_content_seq")
    var lastContentSeq: String? = null,

    @Column(name = "content_Type")
    @Enumerated(EnumType.STRING)
    val contentType: ContentType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {
    fun completeScrap(blogContents: BlogContents) {
        this.lastScrapPostDate = blogContents.lastScrapPostDate
        this.lastContentSeq = blogContents.lastScrapId
    }


    companion object {
        fun of(vendor: Vendor, contentType: ContentType): ContentScrap {
            return ContentScrap(
                contentType = contentType,
                vendor = vendor,
            )
        }
    }
}