package com.gsd.techbloghub.domain.user.model

import jakarta.persistence.*

/**
 * Created by Yohan lee
 * Created on 2023/03/24.
 **/
@Entity
@Table(name = "users")
class User(


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) {
}