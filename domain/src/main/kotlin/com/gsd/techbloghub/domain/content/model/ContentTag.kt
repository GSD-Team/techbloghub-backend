package com.gsd.techbloghub.domain.content.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/03/18.
 **/

@Entity
@Table(name = "content_tag")
@EntityListeners(AuditingEntityListener::class)
class ContentTag(
    @Column(name = "tag_name")
    val tagName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    val content: Content,

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {
}