package com.gsd.techbloghub.domain.user.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

/**
 * Created by Yohan lee
 * Created on 2023/03/24.
 **/
@Entity
@Table(name = "users")
@EntityListeners(value = [AuditingEntityListener::class])
class User(

    @Column(name = "user_name")
    val name: String,

    @Column(name = "github_login_id")
    var githubLoginId: String?,

    @Column(name = "profile_image_url")
    var profileImageURL: String?,

    @Column(name = "recent_login_date")
    var recentLoginDate: LocalDateTime?,

    @CreatedDate
    @Column(name = "register_date")
    var registerDate: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {
}