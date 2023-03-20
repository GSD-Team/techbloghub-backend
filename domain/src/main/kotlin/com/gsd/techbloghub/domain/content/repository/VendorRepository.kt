package com.gsd.techbloghub.domain.content.repository

import com.gsd.techbloghub.domain.content.model.Vendor
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Yohan lee
 * Created on 2023/03/19.
 **/
interface VendorRepository : JpaRepository<Vendor, Long>