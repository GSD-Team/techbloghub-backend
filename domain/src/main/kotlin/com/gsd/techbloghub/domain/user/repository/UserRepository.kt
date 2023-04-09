package com.gsd.techbloghub.domain.user.repository

import com.gsd.techbloghub.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository


/**
 * Created by Yohan lee
 * Created on 2023/03/24.
 **/
interface UserRepository : JpaRepository<User, Long>