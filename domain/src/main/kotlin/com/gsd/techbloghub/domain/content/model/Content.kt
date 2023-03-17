package com.gsd.techbloghub.domain.content.model

import com.gsd.techbloghub.domain.content.constant.ContentType
import com.gsd.techbloghub.domain.content.constant.JobType
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/03/18.
 **/

@Entity
@Table(name = "content")
@EntityListeners(AuditingEntityListener::class)
class Content(

    @Column(name = "content_seq")
    val contentSeq: String,

    @Column(name = "content_title")
    val title: String,


    @Column(name = "content_views")
    val contentViews: Long = 0,

    @Column(name = "post_date")
    val postDate: LocalDate,

    @Column(name = "thumbnail_url")
    val thumbnailURL: String? = null,

    @Column(name = "detail_url")
    val detailURL: String,

    @Column(name = "job_type")
    @Enumerated(EnumType.STRING)
    val jobType: JobType,

    @Column(name = "content_type")
    @Enumerated(EnumType.STRING)
    val contentType: ContentType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor,

    @CreatedDate
    @Column(name = "created_date")
    val createdDate: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {
}