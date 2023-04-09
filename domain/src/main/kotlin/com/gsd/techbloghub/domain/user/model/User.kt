package com.gsd.techbloghub.domain.user.model

import com.gsd.techbloghub.core.client.oauth.http.GithubOauth2User
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
    var recentLoginDate: LocalDateTime? = null,

    @CreatedDate
    @Column(name = "register_date")
    var registerDate: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {
    fun login() {
        this.recentLoginDate = LocalDateTime.now()
    }

    companion object {
        fun githubOf(githubOauth2User: GithubOauth2User): User {
            return User(
                name = githubOauth2User.userName,
                githubLoginId = githubOauth2User.userSeq,
                profileImageURL = githubOauth2User.profileImageURL,
            )
        }
    }
}